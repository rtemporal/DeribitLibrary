package temporal.deribit.library;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import temporal.deribit.dto.Response;
import temporal.deribit.notifications.Method;
import temporal.deribit.notifications.Notification;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

public class MessageReader implements Runnable
{
	public MessageReader()
	{
		inputQueue = new LinkedBlockingQueue<>();
		futureResponseMap = new HashMap<>();
		objectMapper = JsonMapper.builder().enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES).build();
	}

	public synchronized void	start()
	{
		if (thread != null && thread.isAlive())
			throw new IllegalStateException();

		thread = new Thread(this, getClass().getSimpleName());
		thread.setDaemon(true);
		thread.start();
	}

	public MessageReader	stop()
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
				String	message = inputQueue.take();

				if (message == STOP)
					break;

				onMessage(message);
			}
		}
		catch (InterruptedException	e)
		{
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	public void	put(FutureResponse<?>	futureResponse)
	{
		futureResponseMap.put(futureResponse.getId(), futureResponse);
	}

	public void	post(String	message)
	{
		inputQueue.add(message);
	}

	public void	clear()
	{
		inputQueue.clear();
	}

	private void	onMessage(String	message)
	{
    	JsonNode	root = objectMapper.readTree(message);

        if (root.has("method") && root.has("params"))
        	if ("subscription".equals(root.get("method").asString()))
        		onNotification(root);
        	else
            	onMethod(root);
		else
			if (root.has("id"))
				onResponse(root);
        	else
        		throw new IllegalArgumentException("Unexpected message format.");
	}

	private void	onResponse(JsonNode	node)
	{
		int	id = node.get("id").asInt();
		FutureResponse<?>	futureResponse = futureResponseMap.remove(id);

		if (futureResponse == null)
		{
       		System.out.println("Future response not found for response:");
       		System.out.println(node.toPrettyString());
       		return;
		}

		TypeReference<?>	type = futureResponse.getTypeReference();
		Response<?>	response;

		try
		{
			response = (Response<?>)objectMapper.treeToValue(node, type);
			futureResponse.setResponse(response);
		}
		catch(JacksonException	e)
		{
			futureResponse.setError(e);
		}
	}

	private void	onNotification(JsonNode	node)
	{
		JsonNode	params = node.get("params");
		String	id = params.get("channel").asString();
		Channel<?>	channel = Channel.get(id);

		if (channel == null)
		{
       		System.out.println("Channel not found for notification:");
       		System.out.println(node.toPrettyString());
       		return;
		}

		TypeReference<?>	type = channel.getTypeReference();
		Notification<?>	notification;

		try
		{
			notification = (Notification<?>)objectMapper.treeToValue(node, type);
			channel.setNotification(notification);
		}
		catch (JacksonException e)
		{
			channel.setError(e);
		}
	}

	private void	onMethod(JsonNode	node)
	{
		String	id = node.get("method").asString();
		Callback<?>	callback = Callback.get(id);

		if (callback == null)
		{
       		System.out.println("Callback not found for method:");
       		System.out.println(node.toPrettyString());
       		return;
		}

		TypeReference<?>	type = callback.getTypeReference();
		Method<?>	method;

		try
		{
			method = (Method<?>)objectMapper.treeToValue(node, type);
			callback.setMethod(method);
		}
		catch(JacksonException	e)
		{
			callback.setError(e);
		}
	}

	private BlockingQueue<String>	inputQueue;
	private ObjectMapper	objectMapper;
	private Map<Integer,FutureResponse<?>>	futureResponseMap;
	private Thread	thread;
	private static final String	STOP = new String();
}
