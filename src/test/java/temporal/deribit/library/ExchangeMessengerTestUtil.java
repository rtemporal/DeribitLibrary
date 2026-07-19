package temporal.deribit.library;

import java.net.URI;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import temporal.deribit.dto.Authorization;
import temporal.deribit.params.logout;

public class ExchangeMessengerTestUtil
{
	public static final String	BTC_PERPETUAL = "BTC-PERPETUAL";
	public static final String	BTC_USDC = "BTC-USDC";

	public static URI	wss;
	public static MessageReader	messageReader;
	public static ExchangeSocket	exchangeSocket;
	public static MessageWriter	messageWriter;
	public static ExchangeMessenger	exchangeMessenger;
	public static Authorization	authorization;

	public static <T> T	get(Future<T> future) throws Exception
	{
		return future.get(15000, TimeUnit.MILLISECONDS);
	}

	public static void	setupAll() throws Exception
	{
		DeribitKey	deribitKey = Keyring.library2SubAccount.deribitKey;

		wss = new URI("wss://test.deribit.com/ws/api/v2");
		messageReader = new MessageReader();
		exchangeSocket = new ExchangeSocket(wss, messageReader);
		messageWriter = new MessageWriter(exchangeSocket);
		exchangeMessenger = new ExchangeMessenger(messageReader, messageWriter);
		exchangeSocket.connectBlocking();
		messageReader.start();
		messageWriter.start();
		authorization = get(exchangeMessenger.auth(deribitKey.sign("ExchangeMessengerTest")));
	}

	public static void	teardownAll()
	{
		System.out.println("begin teardownAll");
		try
		{
			exchangeMessenger.logout(new logout(authorization, null));
		}
		catch(Exception	e)
		{
			System.out.println("logout during teardown: " + e.getMessage());
		}
		try
		{
			messageWriter.stop().join();
		}
		catch(Exception	e)
		{
			System.out.println("stop writer during teardown: " + e.getMessage());
		}
		try
		{
			messageReader.stop().join();
		}
		catch(Exception	e)
		{
			System.out.println("stop reader during teardown: " + e.getMessage());
		}
		try
		{
			exchangeSocket.closeBlocking();
		}
		catch(Exception	e)
		{
			System.out.println("close socket during teardown: " + e.getMessage());
		}
		System.out.println("end teardownAll");
	}
}
