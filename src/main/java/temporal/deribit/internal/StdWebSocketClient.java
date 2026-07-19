package temporal.deribit.internal;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import temporal.deribit.library.ExchangeSocket;

public class StdWebSocketClient
{
	public StdWebSocketClient(ExchangeSocket	exchangeSocket, URI	uri)
	{
		this.exchangeSocket = exchangeSocket;
		this.uri = uri;
	}

	public boolean	connectBlocking()
	{
		Listener	listener = new StdWebSocketListener();
		CompletableFuture<WebSocket>	wsFuture = getClient().newWebSocketBuilder().buildAsync(uri, listener);
		boolean	completed;

		try
		{
			openLatch = new CountDownLatch(1);
			wsFuture.get(CONNECT_TIMEOUT, TIMEOUT_UNIT);
			completed = openLatch.await(CONNECT_TIMEOUT, TIMEOUT_UNIT);
		}
		catch(InterruptedException	e)
		{
	        Thread.currentThread().interrupt();
			completed = false;
		}
		catch(ExecutionException | TimeoutException	e)
		{
			completed = false;
		}

		openLatch = null;

		return completed;
	}

	public boolean	closeBlocking()
	{
		WebSocket	ws = webSocket;

		if (ws == null)
			return false;

		boolean	completed;

		try
		{
			closeLatch = new CountDownLatch(1);
			ws.sendClose(1000, "Normal closure").get(CLOSE_TIMEOUT, TIMEOUT_UNIT);
			completed = closeLatch.await(CLOSE_TIMEOUT, TIMEOUT_UNIT);
		}
		catch(InterruptedException	e)
		{
	        Thread.currentThread().interrupt();
	        completed = false;
		}
		catch(ExecutionException | TimeoutException	e)
		{
	        completed = false;
		}

		closeLatch = null;

		return completed;
	}

	public void	send(String	message)
	{
		WebSocket	ws = webSocket;

		if (ws == null)
			throw new IllegalStateException("WebSocket connection is closed");

		ws.sendText(message, true).join();
	}

	public void	send(ByteBuffer	data)
	{
		WebSocket	ws = webSocket;

		if (ws == null)
			throw new IllegalStateException("WebSocket connection is closed");

		ws.sendBinary(data, true).join();
	}

	private class StdWebSocketListener implements Listener
	{
		public void onOpen(WebSocket	webSocket)
		{
			StdWebSocketClient.this.webSocket = webSocket;
			exchangeSocket.onOpen();

			CountDownLatch	ol = openLatch;

			if (ol != null)
				ol.countDown();

			Listener.super.onOpen(webSocket);
		}

		public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last)
		{
			stringBuilder.append(data);

			if (last)
			{
				exchangeSocket.onMessage(stringBuilder.toString());

				if (stringBuilder.capacity() > stringBuilder.length() << 1)
					stringBuilder = new StringBuilder(stringBuilder.capacity() >>> 1);
				else
					stringBuilder.setLength(0);
			}

			return Listener.super.onText(webSocket, data, last);
		}

		public CompletionStage<?>	onBinary(WebSocket webSocket, ByteBuffer data, boolean last)
		{
			byteBufferList.add(data);
			listCapacity = Math.max(listCapacity, byteBufferList.size());

			if (last)
			{
				exchangeSocket.onData(concatenateByteBuffers());

				if (listCapacity > byteBufferList.size() << 1)
				{
					listCapacity >>>= 1;
					byteBufferList = new ArrayList<>(listCapacity);
				}
				else
					byteBufferList.clear();
			}

            return Listener.super.onBinary(webSocket, data, last);
		}

		public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason)
		{
			exchangeSocket.onClose(statusCode, reason);
			StdWebSocketClient.this.webSocket = null;

			CountDownLatch	cl = closeLatch;

			if (cl != null)
				cl.countDown();

			return Listener.super.onClose(webSocket, statusCode, reason);
		}

		public void onError(WebSocket webSocket, Throwable	error)
		{
			exchangeSocket.onError(error);

			CountDownLatch	ol = openLatch;
			CountDownLatch	cl = closeLatch;

		    if (ol != null)
		    	ol.countDown();

		    if (cl != null)
		    	cl.countDown();

			Listener.super.onError(webSocket, error);
		}

		private ByteBuffer	concatenateByteBuffers()
		{
		    int	totalSize = 0;

		    for (ByteBuffer	b : byteBufferList)
		        totalSize += b.remaining();

		    ByteBuffer	combined = ByteBuffer.allocate(totalSize);

		    for (ByteBuffer	b : byteBufferList)
		        combined.put(b.duplicate());

		    return combined.flip();
		}

		private StringBuilder	stringBuilder = new StringBuilder();
		private List<ByteBuffer>	byteBufferList = new ArrayList<>();
		private int	listCapacity = 0;
	}

	private static synchronized HttpClient	getClient()
	{
		if (client == null)
			client = HttpClient.newHttpClient();

		return client;
	}

	private final ExchangeSocket	exchangeSocket;
	private final URI	uri;
	private CountDownLatch	openLatch;
	private CountDownLatch	closeLatch;
	private WebSocket	webSocket;
	private static HttpClient	client;
	private static final int	CONNECT_TIMEOUT = 60, CLOSE_TIMEOUT = 60;
	private static final TimeUnit	TIMEOUT_UNIT = TimeUnit.SECONDS;
}
