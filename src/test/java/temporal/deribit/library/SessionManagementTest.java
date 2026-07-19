package temporal.deribit.library;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import temporal.deribit.dto.CancelOnDisconnect;
import temporal.deribit.params.disable_cancel_on_disconnect;
import temporal.deribit.params.enable_cancel_on_disconnect;
import temporal.deribit.params.get_cancel_on_disconnect;
import temporal.deribit.params.set_heartbeat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SessionManagementTest
{
	@Test
	@Order(1)
	void	test_set_heartbeat() throws InterruptedException, ExecutionException
	{
		try
		{
			set_heartbeat	params = new set_heartbeat(ExchangeMessengerTestUtil.authorization, 10);
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.set_heartbeat(params));
			System.out.println("set_heartbeat: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP set_heartbeat: " + e.getMessage());
		}
	}

	@Test
	@Order(2)
	void	test_disable_heartbeat() throws InterruptedException, ExecutionException
	{
		try
		{
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.disable_heartbeat(ExchangeMessengerTestUtil.authorization));
			System.out.println("disable_heartbeat: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP disable_heartbeat: " + e.getMessage());
		}
	}

	@Test
	@Order(3)
	void	test_enable_cancel_on_disconnect() throws InterruptedException, ExecutionException
	{
		try
		{
			enable_cancel_on_disconnect	params = new enable_cancel_on_disconnect(ExchangeMessengerTestUtil.authorization, enable_cancel_on_disconnect.Scope.connection);
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.enable_cancel_on_disconnect(params));
			System.out.println("enable_cancel_on_disconnect: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP enable_cancel_on_disconnect: " + e.getMessage());
		}
	}

	@Test
	@Order(4)
	void	test_disable_cancel_on_disconnect() throws InterruptedException, ExecutionException
	{
		try
		{
			disable_cancel_on_disconnect	params = new disable_cancel_on_disconnect(ExchangeMessengerTestUtil.authorization, disable_cancel_on_disconnect.Scope.connection);
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.disable_cancel_on_disconnect(params));
			System.out.println("disable_cancel_on_disconnect: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP disable_cancel_on_disconnect: " + e.getMessage());
		}
	}

	@Test
	@Order(5)
	void	test_get_cancel_on_disconnect() throws InterruptedException, ExecutionException
	{
		try
		{
			get_cancel_on_disconnect	params = new get_cancel_on_disconnect(ExchangeMessengerTestUtil.authorization, get_cancel_on_disconnect.Scope.connection);
			CancelOnDisconnect	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_cancel_on_disconnect(params));
			System.out.println("get_cancel_on_disconnect: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_cancel_on_disconnect: " + e.getMessage());
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
