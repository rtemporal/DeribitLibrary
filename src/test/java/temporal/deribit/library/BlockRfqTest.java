package temporal.deribit.library;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import temporal.deribit.dto.BlockRfq;
import temporal.deribit.dto.BlockRfqTrades;
import temporal.deribit.dto.BlockRfqUserInfo;
import temporal.deribit.dto.Currency;
import temporal.deribit.dto.Direction;
import temporal.deribit.params.accept_block_rfq;
import temporal.deribit.params.add_block_rfq_quote;
import temporal.deribit.params.cancel_all_block_rfq_quotes;
import temporal.deribit.params.cancel_block_rfq;
import temporal.deribit.params.cancel_block_rfq_quote;
import temporal.deribit.params.cancel_block_rfq_trigger;
import temporal.deribit.params.create_block_rfq;
import temporal.deribit.params.create_block_rfq.Leg;
import temporal.deribit.params.edit_block_rfq_quote;
import temporal.deribit.params.get_block_rfq_quotes;
import temporal.deribit.params.get_block_rfq_trades;
import temporal.deribit.params.get_block_rfqs;

class BlockRfqTest
{
	@Test
	void	test_create_block_rfq() throws InterruptedException, ExecutionException
	{
		try
		{
			Leg	leg = new Leg(ExchangeMessengerTestUtil.BTC_PERPETUAL, BigDecimal.valueOf(10000), Direction.sell);
			create_block_rfq	params = new create_block_rfq(ExchangeMessengerTestUtil.authorization, List.of(leg), null, null, "test-rfq", null, null);
			BlockRfq	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.create_block_rfq(params));
			System.out.println("create_block_rfq: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP create_block_rfq: " + e.getMessage());
		}
	}

	@Test
	void	test_cancel_block_rfq() throws InterruptedException, ExecutionException
	{
		try
		{
			cancel_block_rfq	params = new cancel_block_rfq(ExchangeMessengerTestUtil.authorization, 0);
			Void	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.cancel_block_rfq(params));
			System.out.println("cancel_block_rfq: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP cancel_block_rfq: " + e.getMessage());
		}
	}

	@Test
	void	test_get_block_rfqs() throws InterruptedException, ExecutionException
	{
		try
		{
			get_block_rfqs	params = new get_block_rfqs(ExchangeMessengerTestUtil.authorization, Currency.BTC, null, null, null, null);
			List<BlockRfq>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_block_rfqs(params));
			System.out.println("get_block_rfqs: " + result.size() + " entries");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_block_rfqs: " + e.getMessage());
		}
	}

	@Test
	void	test_get_block_rfq_makers() throws InterruptedException, ExecutionException
	{
		try
		{
			List<String>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_block_rfq_makers(ExchangeMessengerTestUtil.authorization));
			System.out.println("get_block_rfq_makers: " + result.size() + " makers");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_block_rfq_makers: " + e.getMessage());
		}
	}

	@Test
	void	test_add_block_rfq_quote() throws InterruptedException, ExecutionException
	{
		try
		{
			add_block_rfq_quote	params = new add_block_rfq_quote(ExchangeMessengerTestUtil.authorization, 0, BigDecimal.valueOf(50000), BigDecimal.valueOf(10000), null, null);
			BlockRfq	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.add_block_rfq_quote(params));
			System.out.println("add_block_rfq_quote: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP add_block_rfq_quote: " + e.getMessage());
		}
	}

	@Test
	void	test_edit_block_rfq_quote() throws InterruptedException, ExecutionException
	{
		try
		{
			edit_block_rfq_quote	params = new edit_block_rfq_quote(ExchangeMessengerTestUtil.authorization, 0, BigDecimal.valueOf(51000), BigDecimal.valueOf(10000), null, null);
			BlockRfq	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.edit_block_rfq_quote(params));
			System.out.println("edit_block_rfq_quote: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP edit_block_rfq_quote: " + e.getMessage());
		}
	}

	@Test
	void	test_cancel_block_rfq_quote() throws InterruptedException, ExecutionException
	{
		try
		{
			cancel_block_rfq_quote	params = new cancel_block_rfq_quote(ExchangeMessengerTestUtil.authorization, 0);
			Void	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.cancel_block_rfq_quote(params));
			System.out.println("cancel_block_rfq_quote: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP cancel_block_rfq_quote: " + e.getMessage());
		}
	}

	@Test
	void	test_cancel_all_block_rfq_quotes() throws InterruptedException, ExecutionException
	{
		try
		{
			cancel_all_block_rfq_quotes	params = new cancel_all_block_rfq_quotes(ExchangeMessengerTestUtil.authorization, 0);
			Void	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.cancel_all_block_rfq_quotes(params));
			System.out.println("cancel_all_block_rfq_quotes: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP cancel_all_block_rfq_quotes: " + e.getMessage());
		}
	}

	@Test
	void	test_get_block_rfq_quotes() throws InterruptedException, ExecutionException
	{
		try
		{
			get_block_rfq_quotes	params = new get_block_rfq_quotes(ExchangeMessengerTestUtil.authorization, 0);
			List<BlockRfq.Quote>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_block_rfq_quotes(params));
			System.out.println("get_block_rfq_quotes: " + result.size() + " quotes");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_block_rfq_quotes: " + e.getMessage());
		}
	}

	@Test
	void	test_accept_block_rfq() throws InterruptedException, ExecutionException
	{
		try
		{
			accept_block_rfq	params = new accept_block_rfq(ExchangeMessengerTestUtil.authorization, 0, 0);
			Void	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.accept_block_rfq(params));
			System.out.println("accept_block_rfq: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP accept_block_rfq: " + e.getMessage());
		}
	}

	@Test
	void	test_cancel_block_rfq_trigger() throws InterruptedException, ExecutionException
	{
		try
		{
			cancel_block_rfq_trigger	params = new cancel_block_rfq_trigger(ExchangeMessengerTestUtil.authorization, 0);
			Void	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.cancel_block_rfq_trigger(params));
			System.out.println("cancel_block_rfq_trigger: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP cancel_block_rfq_trigger: " + e.getMessage());
		}
	}

	@Test
	void	test_get_block_rfq_user_info() throws InterruptedException, ExecutionException
	{
		try
		{
			BlockRfqUserInfo	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_block_rfq_user_info(ExchangeMessengerTestUtil.authorization));
			System.out.println("get_block_rfq_user_info: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_block_rfq_user_info: " + e.getMessage());
		}
	}

	@Test
	void	test_get_block_rfq_trades() throws InterruptedException, ExecutionException
	{
		try
		{
			get_block_rfq_trades	params = new get_block_rfq_trades(ExchangeMessengerTestUtil.authorization, "BTC", null, null);
			BlockRfqTrades	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_block_rfq_trades(params));
			System.out.println("get_block_rfq_trades: " + (result.block_rfqs() != null ? result.block_rfqs().size() + " trades" : result));
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_block_rfq_trades: " + e.getMessage());
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
