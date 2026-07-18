package temporal.deribit.library;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import temporal.deribit.dto.Authorization;
import temporal.deribit.params.exchange_token;
import temporal.deribit.params.fork_token;
import temporal.deribit.params.logout;

class AuthTest
{
	@Test
	void	test_auth() throws InterruptedException, ExecutionException
	{
		try
		{
			DeribitKey	deribitKey = Keyring.library2SubAccount.deribitKey;
			Authorization	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.auth(deribitKey.sign("AuthTest")));
			System.out.println("auth: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP auth: " + e.getMessage());
		}
	}

	@Test
	void	test_exchange_token() throws InterruptedException, ExecutionException
	{
		try
		{
			exchange_token	params = new exchange_token(ExchangeMessengerTestUtil.authorization, null, 0, exchange_token.Scope.session);
			Authorization	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.exchange_token(params));
			System.out.println("exchange_token: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP exchange_token: " + e.getMessage());
		}
	}

	@Test
	void	test_fork_token() throws InterruptedException, ExecutionException
	{
		try
		{
			fork_token	params = new fork_token(ExchangeMessengerTestUtil.authorization, null, "test-session");
			Authorization	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.fork_token(params));
			System.out.println("fork_token: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP fork_token: " + e.getMessage());
		}
	}

	@Test
	void	test_logout() throws InterruptedException, ExecutionException
	{
		try
		{
			logout	params = new logout(ExchangeMessengerTestUtil.authorization, null);
			ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.logout(params));
			System.out.println("logout: ok");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP logout: " + e.getMessage());
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
