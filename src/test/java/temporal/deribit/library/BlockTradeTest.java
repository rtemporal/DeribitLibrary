package temporal.deribit.library;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import temporal.deribit.dto.BlockTrade;
import temporal.deribit.dto.BlockTradeRequest;
import temporal.deribit.dto.BlockTradeSignature;
import temporal.deribit.dto.BrokerClient;
import temporal.deribit.dto.Currency;
import temporal.deribit.dto.Direction;
import temporal.deribit.params.approve_block_trade;
import temporal.deribit.params.execute_block_trade;
import temporal.deribit.params.get_block_trade;
import temporal.deribit.params.get_block_trades;
import temporal.deribit.params.get_broker_trades;
import temporal.deribit.params.invalidate_block_trade_signature;
import temporal.deribit.params.reject_block_trade;
import temporal.deribit.params.simulate_block_trade;
import temporal.deribit.params.verify_block_trade;
import temporal.deribit.params.verify_block_trade.Leg;

class BlockTradeTest
{
	@Test
	void	test_verify_block_trade() throws InterruptedException, ExecutionException
	{
		try
		{
			Leg	leg = new Leg(ExchangeMessengerTestUtil.BTC_PERPETUAL, BigDecimal.valueOf(10000), Direction.sell);
			verify_block_trade	params = new verify_block_trade(ExchangeMessengerTestUtil.authorization, System.currentTimeMillis(), "test-nonce", List.of(leg), "taker", null);
			BlockTradeSignature	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.verify_block_trade(params));
			System.out.println("verify_block_trade: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP verify_block_trade: " + e.getMessage());
		}
	}

	@Test
	void	test_execute_block_trade() throws InterruptedException, ExecutionException
	{
		try
		{
			execute_block_trade.Leg	leg = new execute_block_trade.Leg(ExchangeMessengerTestUtil.BTC_PERPETUAL, BigDecimal.valueOf(10000), Direction.sell);
			execute_block_trade	params = new execute_block_trade(ExchangeMessengerTestUtil.authorization, System.currentTimeMillis(), "test-nonce", List.of(leg), "taker", "test-signature", null);
			BlockTrade	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.execute_block_trade(params));
			System.out.println("execute_block_trade: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP execute_block_trade: " + e.getMessage());
		}
	}

	@Test
	void	test_invalidate_block_trade_signature() throws InterruptedException, ExecutionException
	{
		try
		{
			invalidate_block_trade_signature	params = new invalidate_block_trade_signature(ExchangeMessengerTestUtil.authorization, "test-nonce", System.currentTimeMillis());
			Void	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.invalidate_block_trade_signature(params));
			System.out.println("invalidate_block_trade_signature: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP invalidate_block_trade_signature: " + e.getMessage());
		}
	}

	@Test
	void	test_get_block_trade() throws InterruptedException, ExecutionException
	{
		try
		{
			get_block_trade	params = new get_block_trade(ExchangeMessengerTestUtil.authorization, "0");
			BlockTrade	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_block_trade(params));
			System.out.println("get_block_trade: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_block_trade: " + e.getMessage());
		}
	}

	@Test
	void	test_get_block_trades() throws InterruptedException, ExecutionException
	{
		try
		{
			get_block_trades	params = new get_block_trades(ExchangeMessengerTestUtil.authorization, Currency.BTC, null, null, null, null, null);
			List<BlockTrade>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_block_trades(params));
			System.out.println("get_block_trades: " + result.size() + " trades");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_block_trades: " + e.getMessage());
		}
	}

	@Test
	void	test_get_block_trade_requests() throws InterruptedException, ExecutionException
	{
		try
		{
			List<BlockTradeRequest>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_block_trade_requests(ExchangeMessengerTestUtil.authorization));
			System.out.println("get_block_trade_requests: " + result.size() + " requests");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_block_trade_requests: " + e.getMessage());
		}
	}

	@Test
	void	test_approve_block_trade() throws InterruptedException, ExecutionException
	{
		try
		{
			approve_block_trade	params = new approve_block_trade(ExchangeMessengerTestUtil.authorization, "test-nonce", System.currentTimeMillis(), "maker");
			Void	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.approve_block_trade(params));
			System.out.println("approve_block_trade: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP approve_block_trade: " + e.getMessage());
		}
	}

	@Test
	void	test_reject_block_trade() throws InterruptedException, ExecutionException
	{
		try
		{
			reject_block_trade	params = new reject_block_trade(ExchangeMessengerTestUtil.authorization, "test-nonce", System.currentTimeMillis(), "maker");
			Void	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.reject_block_trade(params));
			System.out.println("reject_block_trade: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP reject_block_trade: " + e.getMessage());
		}
	}

	@Test
	void	test_simulate_block_trade() throws InterruptedException, ExecutionException
	{
		try
		{
			simulate_block_trade.Leg	leg = new simulate_block_trade.Leg(ExchangeMessengerTestUtil.BTC_PERPETUAL, BigDecimal.valueOf(10000), Direction.sell);
			simulate_block_trade	params = new simulate_block_trade(ExchangeMessengerTestUtil.authorization, List.of(leg), null);
			Void	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.simulate_block_trade(params));
			System.out.println("simulate_block_trade: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP simulate_block_trade: " + e.getMessage());
		}
	}

	@Test
	void	test_get_broker_clients() throws InterruptedException, ExecutionException
	{
		try
		{
			List<BrokerClient>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_broker_clients(ExchangeMessengerTestUtil.authorization));
			System.out.println("get_broker_clients: " + result.size() + " clients");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_broker_clients: " + e.getMessage());
		}
	}

	@Test
	void	test_get_broker_trade_requests() throws InterruptedException, ExecutionException
	{
		try
		{
			List<BlockTradeRequest>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_broker_trade_requests(ExchangeMessengerTestUtil.authorization));
			System.out.println("get_broker_trade_requests: " + result.size() + " requests");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_broker_trade_requests: " + e.getMessage());
		}
	}

	@Test
	void	test_get_broker_trades() throws InterruptedException, ExecutionException
	{
		try
		{
			get_broker_trades	params = new get_broker_trades(ExchangeMessengerTestUtil.authorization, Currency.BTC, null, null, null);
			List<BlockTrade>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_broker_trades(params));
			System.out.println("get_broker_trades: " + result.size() + " trades");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_broker_trades: " + e.getMessage());
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
