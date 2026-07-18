package temporal.deribit.library;

import java.net.URI;
import java.nio.ByteBuffer;

import temporal.deribit.internal.StdWebSocketClient;
import temporal.deribit.notifications.Notification.Params;
import temporal.deribit.notifications.OnClose;

public class ExchangeSocket implements TextMessenger
{
	public ExchangeSocket(URI	uri, MessageReader	messageReader)
	{
		this.stdWebSocketClient = new StdWebSocketClient(this, uri);
		this.messageReader = messageReader;

		final long	PERIOD = 200L;
		final long	ONE_PERCENT_TOLERANCE = PERIOD / 100L;

		semaphore = new Semaphore(PERIOD + ONE_PERCENT_TOLERANCE);
	}

	public boolean connectBlocking() throws InterruptedException
	{
		return stdWebSocketClient.connectBlocking();
	}

	public void onOpen()
	{
	}

	public void	send(String	method, String	message)
	{
	    semaphore.acquire();
	    stdWebSocketClient.send(message);
		semaphore.release();
	}

	public void	onMessage(String	message)
	{
		messageReader.post(message);
	}

	public void	onData(ByteBuffer data)
	{
	}

	public void closeBlocking() throws InterruptedException
	{
		stdWebSocketClient.closeBlocking();
	}

	public void	onClose(int	code, String	reason)
	{
		OnClose	onClose = new OnClose(code, reason);
		Channel<OnClose>	channel = Channel.getOnClose();
		Params<OnClose>	params = new Params<>(channel.getId(), null, onClose);

		channel.setData(params);
	}

	public void	onError(Throwable	e)
	{
		e.printStackTrace();
	}

	private StdWebSocketClient	stdWebSocketClient;
	private MessageReader	messageReader;
	private Semaphore	semaphore;
}
