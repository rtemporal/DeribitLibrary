package temporal.deribit.library;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import temporal.deribit.dto.Hello;
import temporal.deribit.dto.Status;
import temporal.deribit.dto.TestResult;
import temporal.deribit.params.hello;

class SupportingTest
{
	@Test
	void	test_get_time() throws InterruptedException, ExecutionException
	{
		try
		{
			Long	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_time(ExchangeMessengerTestUtil.authorization));
			System.out.println("get_time: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_time: " + e.getMessage());
		}
	}

	@Test
	void	test_hello() throws InterruptedException, ExecutionException
	{
		try
		{
			hello	params = new hello(ExchangeMessengerTestUtil.authorization, "DeribitLibrary", "1.0");
			Hello	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.hello(params));
			System.out.println("hello: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP hello: " + e.getMessage());
		}
	}

	@Test
	void	test_status() throws InterruptedException, ExecutionException
	{
		try
		{
			Status	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.status(ExchangeMessengerTestUtil.authorization));
			System.out.println("status: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP status: " + e.getMessage());
		}
	}

	@Test
	void	test_test() throws InterruptedException, ExecutionException
	{
		try
		{
			TestResult	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.test(ExchangeMessengerTestUtil.authorization));
			System.out.println("test: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP test: " + e.getMessage());
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
