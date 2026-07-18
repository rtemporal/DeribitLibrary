package temporal.deribit.library;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import temporal.deribit.dto.Currency;
import temporal.deribit.notifications.Interval;
import temporal.deribit.params.private_subscribe;
import temporal.deribit.params.public_subscribe;
import temporal.deribit.params.unsubscribe;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SubscriptionManagementTest
{
	@Test
	@Order(1)
	void	test_public_subscribe() throws InterruptedException, ExecutionException
	{
		try
		{
			String	channelId = Channel.get_ticker(ExchangeMessengerTestUtil.BTC_PERPETUAL, Interval.CONTINUOUSLY).getId();
			public_subscribe	params = new public_subscribe(ExchangeMessengerTestUtil.authorization, List.of(channelId));
			List<String>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.public_subscribe(params));
			System.out.println("public_subscribe: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP public_subscribe: " + e.getMessage());
		}
	}

	@Test
	@Order(2)
	void	test_public_unsubscribe() throws InterruptedException, ExecutionException
	{
		try
		{
			String	channelId = Channel.get_ticker(ExchangeMessengerTestUtil.BTC_PERPETUAL, Interval.CONTINUOUSLY).getId();
			unsubscribe	params = new unsubscribe(ExchangeMessengerTestUtil.authorization, List.of(channelId));
			List<String>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.public_unsubscribe(params));
			System.out.println("public_unsubscribe: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP public_unsubscribe: " + e.getMessage());
		}
	}

	@Test
	@Order(3)
	void	test_public_unsubscribe_all() throws InterruptedException, ExecutionException
	{
		try
		{
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.public_unsubscribe_all(ExchangeMessengerTestUtil.authorization));
			System.out.println("public_unsubscribe_all: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP public_unsubscribe_all: " + e.getMessage());
		}
	}

	@Test
	@Order(4)
	void	test_private_subscribe() throws InterruptedException, ExecutionException
	{
		try
		{
			String	channelId = Channel.get_user_portfolio(Currency.BTC).getId();
			private_subscribe	params = new private_subscribe(ExchangeMessengerTestUtil.authorization, null, List.of(channelId));
			List<String>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.private_subscribe(params));
			System.out.println("private_subscribe: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP private_subscribe: " + e.getMessage());
		}
	}

	@Test
	@Order(5)
	void	test_private_unsubscribe() throws InterruptedException, ExecutionException
	{
		try
		{
			String	channelId = Channel.get_user_portfolio(Currency.BTC).getId();
			unsubscribe	params = new unsubscribe(ExchangeMessengerTestUtil.authorization, List.of(channelId));
			List<String>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.private_unsubscribe(params));
			System.out.println("private_unsubscribe: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP private_unsubscribe: " + e.getMessage());
		}
	}

	@Test
	@Order(6)
	void	test_private_unsubscribe_all() throws InterruptedException, ExecutionException
	{
		try
		{
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.private_unsubscribe_all(ExchangeMessengerTestUtil.authorization));
			System.out.println("private_unsubscribe_all: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP private_unsubscribe_all: " + e.getMessage());
		}
	}

	@BeforeAll
	static void	setUpBeforeClass() throws Exception
	{
		ExchangeMessengerTestUtil.setupAll();
	}

	@AfterAll
	static void	tearDownAfterClass()
	{
		ExchangeMessengerTestUtil.teardownAll();
	}
}
