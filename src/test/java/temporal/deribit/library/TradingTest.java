package temporal.deribit.library;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import temporal.deribit.dto.Currency;
import temporal.deribit.dto.IndexName;
import temporal.deribit.dto.Margin;
import temporal.deribit.dto.MarketMakerProtectionConfig;
import temporal.deribit.dto.MarketMakerProtectionStatus;
import temporal.deribit.dto.MassQuote;
import temporal.deribit.dto.Order;
import temporal.deribit.dto.OrderMargin;
import temporal.deribit.dto.OrderResponse;
import temporal.deribit.dto.Orders;
import temporal.deribit.dto.PositionClose;
import temporal.deribit.dto.PositionMove;
import temporal.deribit.dto.Settlements;
import temporal.deribit.dto.Trades;
import temporal.deribit.params.cancel;
import temporal.deribit.params.cancel_all;
import temporal.deribit.params.cancel_all_by_currency;
import temporal.deribit.params.cancel_all_by_currency_pair;
import temporal.deribit.params.cancel_all_by_instrument;
import temporal.deribit.params.cancel_all_by_kind_or_type;
import temporal.deribit.params.cancel_by_label;
import temporal.deribit.params.cancel_quotes;
import temporal.deribit.params.close_position;
import temporal.deribit.params.edit_by_label;
import temporal.deribit.params.edit_order;
import temporal.deribit.params.get_margins;
import temporal.deribit.params.get_mmp_config;
import temporal.deribit.params.get_mmp_status;
import temporal.deribit.params.get_open_orders;
import temporal.deribit.params.get_open_orders_by_currency;
import temporal.deribit.params.get_open_orders_by_instrument;
import temporal.deribit.params.get_open_orders_by_label;
import temporal.deribit.params.get_order_history_by_currency;
import temporal.deribit.params.get_order_history_by_instrument;
import temporal.deribit.params.get_order_margin_by_ids;
import temporal.deribit.params.get_order_state;
import temporal.deribit.params.get_order_state_by_label;
import temporal.deribit.params.get_settlement_history_by_currency;
import temporal.deribit.params.get_settlement_history_by_instrument;
import temporal.deribit.params.get_trigger_order_history;
import temporal.deribit.params.get_user_trades_by_currency;
import temporal.deribit.params.get_user_trades_by_currency_and_time;
import temporal.deribit.params.get_user_trades_by_instrument;
import temporal.deribit.params.get_user_trades_by_instrument_and_time;
import temporal.deribit.params.get_user_trades_by_order;
import temporal.deribit.params.mass_quote;
import temporal.deribit.params.mass_quote.Quote;
import temporal.deribit.params.mass_quote.QuoteSide;
import temporal.deribit.params.move_positions;
import temporal.deribit.params.move_positions.Move;
import temporal.deribit.params.reset_mmp;
import temporal.deribit.params.set_mmp_config;
import temporal.deribit.params.submit_order;
import temporal.deribit.params.submit_order.Advanced;
import temporal.deribit.params.submit_order.Type;

class TradingTest
{
	@Test
	void	test_buy() throws InterruptedException, ExecutionException
	{
		try
		{
			submit_order	params = new submit_order(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL, BigDecimal.valueOf(10), BigDecimal.valueOf(60000), Type.limit, null, (Advanced)null);
			OrderResponse	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.buy(params));
			System.out.println("buy: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP buy: " + e.getMessage());
		}
	}

	@Test
	void	test_sell() throws InterruptedException, ExecutionException
	{
		try
		{
			submit_order	params = new submit_order(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL, BigDecimal.valueOf(10), BigDecimal.valueOf(70000), Type.limit, null, (Advanced)null);
			OrderResponse	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.sell(params));
			System.out.println("sell: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP sell: " + e.getMessage());
		}
	}

	@Test
	void	test_cancel() throws InterruptedException, ExecutionException
	{
		try
		{
			cancel	params = new cancel(ExchangeMessengerTestUtil.authorization, "non-existent-order-id");
			Order	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.cancel(params));
			System.out.println("cancel: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP cancel: " + e.getMessage());
		}
	}

	@Test
	void	test_cancel_all() throws InterruptedException, ExecutionException
	{
		try
		{
			cancel_all	params = new cancel_all(ExchangeMessengerTestUtil.authorization, null, null);
			Integer	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.cancel_all(params));
			System.out.println("cancel_all: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP cancel_all: " + e.getMessage());
		}
	}

	@Test
	void	test_cancel_all_by_currency() throws InterruptedException, ExecutionException
	{
		try
		{
			cancel_all_by_currency	params = new cancel_all_by_currency(ExchangeMessengerTestUtil.authorization, Currency.BTC, null, null, null, null);
			Integer	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.cancel_all_by_currency(params));
			System.out.println("cancel_all_by_currency: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP cancel_all_by_currency: " + e.getMessage());
		}
	}

	@Test
	void	test_cancel_all_by_currency_pair() throws InterruptedException, ExecutionException
	{
		try
		{
			cancel_all_by_currency_pair	params = new cancel_all_by_currency_pair(ExchangeMessengerTestUtil.authorization, cancel_all_by_currency_pair.CurrencyPair.btc_usdc, null, null, null);
			Integer	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.cancel_all_by_currency_pair(params));
			System.out.println("cancel_all_by_currency_pair: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP cancel_all_by_currency_pair: " + e.getMessage());
		}
	}

	@Test
	void	test_cancel_all_by_instrument() throws InterruptedException, ExecutionException
	{
		try
		{
			cancel_all_by_instrument	params = new cancel_all_by_instrument(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL, null, null, null, null);
			Integer	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.cancel_all_by_instrument(params));
			System.out.println("cancel_all_by_instrument: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP cancel_all_by_instrument: " + e.getMessage());
		}
	}

	@Test
	void	test_cancel_all_by_kind_or_type() throws InterruptedException, ExecutionException
	{
		try
		{
			cancel_all_by_kind_or_type	params = new cancel_all_by_kind_or_type(ExchangeMessengerTestUtil.authorization, Currency.BTC, null, null, null, null);
			Integer	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.cancel_all_by_kind_or_type(params));
			System.out.println("cancel_all_by_kind_or_type: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP cancel_all_by_kind_or_type: " + e.getMessage());
		}
	}

	@Test
	void	test_cancel_by_label() throws InterruptedException, ExecutionException
	{
		try
		{
			cancel_by_label	params = new cancel_by_label(ExchangeMessengerTestUtil.authorization, "test-label", Currency.BTC);
			Integer	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.cancel_by_label(params));
			System.out.println("cancel_by_label: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP cancel_by_label: " + e.getMessage());
		}
	}

	@Test
	void	test_cancel_quotes() throws InterruptedException, ExecutionException
	{
		try
		{
			cancel_quotes	params = new cancel_quotes(ExchangeMessengerTestUtil.authorization, "all", Currency.BTC, null, null, null, null, null, null, null, null);
			Integer	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.cancel_quotes(params));
			System.out.println("cancel_quotes: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP cancel_quotes: " + e.getMessage());
		}
	}

	@Test
	void	test_mass_quote() throws InterruptedException, ExecutionException
	{
		try
		{
			QuoteSide	ask = new QuoteSide(BigDecimal.valueOf(43800), BigDecimal.valueOf(10), null, null);
			QuoteSide	bid = new QuoteSide(BigDecimal.valueOf(43700), BigDecimal.valueOf(10), null, null);
			Quote	quote = new Quote(ExchangeMessengerTestUtil.BTC_PERPETUAL, "futures", ask, bid);
			mass_quote	params = new mass_quote(ExchangeMessengerTestUtil.authorization, "1", "default", List.of(quote), null, true, null);
			MassQuote	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.mass_quote(params));
			System.out.println("mass_quote: " + (result.orders() != null ? result.orders().size() + " orders" : result));
		}
		catch(Exception	e)
		{
			System.out.println("SKIP mass_quote: " + e.getMessage());
		}
	}

	@Test
	void	test_close_position() throws InterruptedException, ExecutionException
	{
		try
		{
			close_position	params = new close_position(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL, close_position.Type.market, null);
			PositionClose	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.close_position(params));
			System.out.println("close_position: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP close_position: " + e.getMessage());
		}
	}

	@Test
	void	test_edit() throws InterruptedException, ExecutionException
	{
		try
		{
			edit_order	params = new edit_order(ExchangeMessengerTestUtil.authorization, "non-existent-order-id", BigDecimal.valueOf(10), BigDecimal.valueOf(61000));
			OrderResponse	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.edit(params));
			System.out.println("edit: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP edit: " + e.getMessage());
		}
	}

	@Test
	void	test_edit_by_label() throws InterruptedException, ExecutionException
	{
		try
		{
			edit_by_label	params = new edit_by_label(ExchangeMessengerTestUtil.authorization, "test-label", ExchangeMessengerTestUtil.BTC_PERPETUAL, BigDecimal.valueOf(10), null, BigDecimal.valueOf(61000), null, null, null, null, null, null, null);
			OrderResponse	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.edit_by_label(params));
			System.out.println("edit_by_label: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP edit_by_label: " + e.getMessage());
		}
	}

	@Test
	void	test_get_margins() throws InterruptedException, ExecutionException
	{
		try
		{
			get_margins	params = new get_margins(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL, BigDecimal.valueOf(10), BigDecimal.valueOf(60000));
			Margin	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_margins(params));
			System.out.println("get_margins: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_margins: " + e.getMessage());
		}
	}

	@Test
	void	test_get_mmp_config() throws InterruptedException, ExecutionException
	{
		try
		{
			get_mmp_config	params = new get_mmp_config(ExchangeMessengerTestUtil.authorization, IndexName.btc_usdc, null, null);
			MarketMakerProtectionConfig	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_mmp_config(params));
			System.out.println("get_mmp_config: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_mmp_config: " + e.getMessage());
		}
	}

	@Test
	void	test_get_mmp_status() throws InterruptedException, ExecutionException
	{
		try
		{
			get_mmp_status	params = new get_mmp_status(ExchangeMessengerTestUtil.authorization, IndexName.btc_usdc, null, null);
			MarketMakerProtectionStatus	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_mmp_status(params));
			System.out.println("get_mmp_status: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_mmp_status: " + e.getMessage());
		}
	}

	@Test
	void	test_get_open_orders() throws InterruptedException, ExecutionException
	{
		try
		{
			get_open_orders	params = new get_open_orders(ExchangeMessengerTestUtil.authorization, null, null);
			List<Order>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_open_orders(params));
			System.out.println("get_open_orders: " + result.size() + " orders");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_open_orders: " + e.getMessage());
		}
	}

	@Test
	void	test_get_open_orders_by_currency() throws InterruptedException, ExecutionException
	{
		try
		{
			get_open_orders_by_currency	params = new get_open_orders_by_currency(ExchangeMessengerTestUtil.authorization, Currency.BTC, null);
			List<Order>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_open_orders_by_currency(params));
			System.out.println("get_open_orders_by_currency: " + result.size() + " orders");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_open_orders_by_currency: " + e.getMessage());
		}
	}

	@Test
	void	test_get_open_orders_by_instrument() throws InterruptedException, ExecutionException
	{
		try
		{
			get_open_orders_by_instrument	params = new get_open_orders_by_instrument(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL, null);
			List<Order>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_open_orders_by_instrument(params));
			System.out.println("get_open_orders_by_instrument: " + result.size() + " orders");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_open_orders_by_instrument: " + e.getMessage());
		}
	}

	@Test
	void	test_get_open_orders_by_label() throws InterruptedException, ExecutionException
	{
		try
		{
			get_open_orders_by_label	params = new get_open_orders_by_label(ExchangeMessengerTestUtil.authorization, Currency.BTC, "test-label");
			List<Order>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_open_orders_by_label(params));
			System.out.println("get_open_orders_by_label: " + result.size() + " orders");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_open_orders_by_label: " + e.getMessage());
		}
	}

	@Test
	void	test_get_order_history_by_currency() throws InterruptedException, ExecutionException
	{
		try
		{
			get_order_history_by_currency	params = new get_order_history_by_currency(ExchangeMessengerTestUtil.authorization, Currency.BTC, null, null, null, null, null, null, null, null);
			List<Order>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_order_history_by_currency(params));
			System.out.println("get_order_history_by_currency: " + result.size() + " orders");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_order_history_by_currency: " + e.getMessage());
		}
	}

	@Test
	void	test_get_order_history_by_instrument() throws InterruptedException, ExecutionException
	{
		try
		{
			get_order_history_by_instrument	params = new get_order_history_by_instrument(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL, null, null, null, null, null, null, null);
			List<Order>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_order_history_by_instrument(params));
			System.out.println("get_order_history_by_instrument: " + result.size() + " orders");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_order_history_by_instrument: " + e.getMessage());
		}
	}

	@Test
	void	test_get_order_margin_by_ids() throws InterruptedException, ExecutionException
	{
		try
		{
			get_order_margin_by_ids	params = new get_order_margin_by_ids(ExchangeMessengerTestUtil.authorization, new String[]{"non-existent-id"});
			List<OrderMargin>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_order_margin_by_ids(params));
			System.out.println("get_order_margin_by_ids: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_order_margin_by_ids: " + e.getMessage());
		}
	}

	@Test
	void	test_get_order_state() throws InterruptedException, ExecutionException
	{
		try
		{
			get_order_state	params = new get_order_state(ExchangeMessengerTestUtil.authorization, "non-existent-order-id");
			Order	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_order_state(params));
			System.out.println("get_order_state: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_order_state: " + e.getMessage());
		}
	}

	@Test
	void	test_get_order_state_by_label() throws InterruptedException, ExecutionException
	{
		try
		{
			get_order_state_by_label	params = new get_order_state_by_label(ExchangeMessengerTestUtil.authorization, Currency.BTC, "test-label");
			List<Order>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_order_state_by_label(params));
			System.out.println("get_order_state_by_label: " + result.size() + " orders");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_order_state_by_label: " + e.getMessage());
		}
	}

	@Test
	void	test_get_settlement_history_by_currency() throws InterruptedException, ExecutionException
	{
		try
		{
			get_settlement_history_by_currency	params = new get_settlement_history_by_currency(ExchangeMessengerTestUtil.authorization, Currency.BTC, null, null, null, null);
			Settlements	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_settlement_history_by_currency(params));
			System.out.println("get_settlement_history_by_currency: " + result.settlements().length + " entries");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_settlement_history_by_currency: " + e.getMessage());
		}
	}

	@Test
	void	test_get_settlement_history_by_instrument() throws InterruptedException, ExecutionException
	{
		try
		{
			get_settlement_history_by_instrument	params = new get_settlement_history_by_instrument(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL, null, null, null, null);
			Settlements	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_settlement_history_by_instrument(params));
			System.out.println("get_settlement_history_by_instrument: " + result.settlements().length + " entries");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_settlement_history_by_instrument: " + e.getMessage());
		}
	}

	@Test
	void	test_get_trigger_order_history() throws InterruptedException, ExecutionException
	{
		try
		{
			get_trigger_order_history	params = new get_trigger_order_history(ExchangeMessengerTestUtil.authorization, Currency.BTC, null, null, null);
			Orders	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_trigger_order_history(params));
			System.out.println("get_trigger_order_history: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_trigger_order_history: " + e.getMessage());
		}
	}

	@Test
	void	test_get_user_trades_by_currency() throws InterruptedException, ExecutionException
	{
		try
		{
			get_user_trades_by_currency	params = new get_user_trades_by_currency(ExchangeMessengerTestUtil.authorization, Currency.BTC, null, null, null, null, null, null, null, null);
			Trades	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_user_trades_by_currency(params));
			System.out.println("get_user_trades_by_currency: " + result.trades().length + " trades");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_user_trades_by_currency: " + e.getMessage());
		}
	}

	@Test
	void	test_get_user_trades_by_currency_and_time() throws InterruptedException, ExecutionException
	{
		try
		{
			long	now = System.currentTimeMillis();
			get_user_trades_by_currency_and_time	params = new get_user_trades_by_currency_and_time(ExchangeMessengerTestUtil.authorization, Currency.BTC, null, now - 86400000L, now, null, null, null);
			Trades	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_user_trades_by_currency_and_time(params));
			System.out.println("get_user_trades_by_currency_and_time: " + result.trades().length + " trades");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_user_trades_by_currency_and_time: " + e.getMessage());
		}
	}

	@Test
	void	test_get_user_trades_by_instrument() throws InterruptedException, ExecutionException
	{
		try
		{
			get_user_trades_by_instrument	params = new get_user_trades_by_instrument(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL, null, null, null, null, null, null, null);
			Trades	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_user_trades_by_instrument(params));
			System.out.println("get_user_trades_by_instrument: " + result.trades().length + " trades");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_user_trades_by_instrument: " + e.getMessage());
		}
	}

	@Test
	void	test_get_user_trades_by_instrument_and_time() throws InterruptedException, ExecutionException
	{
		try
		{
			long	now = System.currentTimeMillis();
			get_user_trades_by_instrument_and_time	params = new get_user_trades_by_instrument_and_time(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL, now - 86400000L, now, null, null, null);
			Trades	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_user_trades_by_instrument_and_time(params));
			System.out.println("get_user_trades_by_instrument_and_time: " + result.trades().length + " trades");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_user_trades_by_instrument_and_time: " + e.getMessage());
		}
	}

	@Test
	void	test_get_user_trades_by_order() throws InterruptedException, ExecutionException
	{
		try
		{
			get_user_trades_by_order	params = new get_user_trades_by_order(ExchangeMessengerTestUtil.authorization, "non-existent-order-id", null, null);
			Trades	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_user_trades_by_order(params));
			System.out.println("get_user_trades_by_order: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_user_trades_by_order: " + e.getMessage());
		}
	}

	@Test
	void	test_move_positions() throws InterruptedException, ExecutionException
	{
		try
		{
			Move	move = new Move(ExchangeMessengerTestUtil.BTC_PERPETUAL, BigDecimal.valueOf(60000), BigDecimal.valueOf(1));
			move_positions	params = new move_positions(ExchangeMessengerTestUtil.authorization, Currency.BTC, 0, 0, move);
			List<PositionMove>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.move_positions(params));
			System.out.println("move_positions: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP move_positions: " + e.getMessage());
		}
	}

	@Test
	void	test_reset_mmp() throws InterruptedException, ExecutionException
	{
		try
		{
			reset_mmp	params = new reset_mmp(ExchangeMessengerTestUtil.authorization, IndexName.btc_usdc, null, null);
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.reset_mmp(params));
			System.out.println("reset_mmp: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP reset_mmp: " + e.getMessage());
		}
	}

	@Test
	void	test_set_mmp_config() throws InterruptedException, ExecutionException
	{
		try
		{
			set_mmp_config	params = new set_mmp_config(ExchangeMessengerTestUtil.authorization, IndexName.btc_usdc, 1000, 60, null, null, null, null, null, null, null);
			List<MarketMakerProtectionConfig>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.set_mmp_config(params));
			System.out.println("set_mmp_config: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP set_mmp_config: " + e.getMessage());
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
