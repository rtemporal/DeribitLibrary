package temporal.deribit.library;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.fasterxml.jackson.annotation.JsonInclude;

import temporal.deribit.dto.Response;
import temporal.deribit.params.Request;
import temporal.deribit.params.logout;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

public class MessageWriter implements Runnable
{
	public MessageWriter(TextMessenger	textMessenger)
	{
		this.textMessenger = textMessenger;
		inputQueue = new LinkedBlockingQueue<>();
		futureResponseMap = new HashMap<>();
		objectMapper = JsonMapper.builder().changeDefaultPropertyInclusion
		(
			_ -> JsonInclude.Value.construct(JsonInclude.Include.NON_NULL, JsonInclude.Include.NON_NULL)
		).build();
	}

	public synchronized void	start()
	{
		if (thread != null && thread.isAlive())
			throw new IllegalStateException();

		thread = new Thread(this, getClass().getSimpleName());
		thread.setDaemon(true);
		thread.start();
	}

	public MessageWriter	stop()
	{
		inputQueue.add(STOP);

		return this;
	}

	public synchronized void	join() throws InterruptedException
	{
		thread.join();
	}

	public void run()
	{
		try
		{
			while(true)
			{
				Request<?>	request = inputQueue.take();

				if (request == STOP)
					break;

				onRequest(request);
			}
		}
		catch (InterruptedException	e)
		{
			e.printStackTrace();
		}
	}

	public boolean	isEmpty()
	{
		return inputQueue.isEmpty();
	}

	public void	put(FutureResponse<?>	futureResponse)
	{
		futureResponseMap.put(futureResponse.getId(), futureResponse);
	}

	public void	post(Request<?>	request)
	{
		if (request.method().equals("private/logout"))
		{
			logout	params = (logout)request.params();

			if (params.authorization() == null)
				System.out.println("params.authorization() == null");
		}

		inputQueue.add(request);
	}

	public void	clear()
	{
		inputQueue.clear();
	}
	
	private void	onRequest(Request<?>	request)
	{
		String	message = objectMapper.writeValueAsString(request);

		textMessenger.send(request.method(), message);

		int	id = request.id();
		FutureResponse<?>	futureResponse = futureResponseMap.remove(id);

		if (futureResponse != null)
		{
			Response<Void>	response = new Response<>(id, null);

			futureResponse.setResponse(response);
		}
	}

	private TextMessenger	textMessenger;
	private BlockingQueue<Request<?>>	inputQueue;
	private ObjectMapper	objectMapper;
	private Map<Integer,FutureResponse<?>>	futureResponseMap;
	private Thread	thread;
	private static final Request<?>	STOP = new Request<>(null, null);
}
