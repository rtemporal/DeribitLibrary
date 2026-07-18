package temporal.deribit.library;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class PostOffice implements TextMessenger
{
	public PostOffice(URI	uri, MessageReader	messageReader)
	{
		this.uri = uri;
		this.messageReader = messageReader;
		final long	PERIOD = 200L;
		final long	ONE_PERCENT_TOLERANCE = PERIOD / 100L;

		semaphore = new Semaphore(PERIOD + ONE_PERCENT_TOLERANCE);
	}

	public void	send(String	methodName, String	message)
	{
		URI	methodURI = uri.resolve(methodName);
		HttpRequest httpRequest =
		    HttpRequest.newBuilder()
		        .uri(methodURI)
		        .header("Content-Type", "application/json")
		        .POST(BodyPublishers.ofString(message))
		        .build();

		semaphore.acquire();

		try
		{
			HttpResponse<String>	response = getClient().send(httpRequest, BodyHandlers.ofString());

			messageReader.post(response.body());
		}
		catch (IOException | InterruptedException	e)
		{
			e.printStackTrace();
		}
		finally
		{
			semaphore.release();
		}
	}

	private static synchronized HttpClient	getClient()
	{
		if (client == null)
			client = HttpClient.newHttpClient();

		return client;
	}

	private final URI	uri;
	private final MessageReader	messageReader;
	private Semaphore	semaphore;
	private static HttpClient	client;
}
