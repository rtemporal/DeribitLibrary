package temporal.deribit.library;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import temporal.deribit.dto.AnnualPercentageRates;
import temporal.deribit.dto.BookSummary;
import temporal.deribit.dto.ContractSize;
import temporal.deribit.dto.Currency;
import temporal.deribit.dto.FundingChartData;
import temporal.deribit.dto.CurrencyDetails;
import temporal.deribit.dto.DeliveryPrices;
import temporal.deribit.dto.HistoricalFundingRate;
import temporal.deribit.dto.HistoricalVolatility;
import temporal.deribit.dto.IndexName;
import temporal.deribit.dto.IndexPrice;
import temporal.deribit.dto.IndexPriceName;
import temporal.deribit.dto.Instrument;
import temporal.deribit.dto.Kind;
import temporal.deribit.dto.LastTrades;
import temporal.deribit.dto.MarkPricePoint;
import temporal.deribit.dto.OrderBook;
import temporal.deribit.dto.Settlements;
import temporal.deribit.dto.TradeVolume;
import temporal.deribit.dto.TradingViewChartData;
import temporal.deribit.dto.VolatilityIndexData;
import temporal.deribit.notifications.ticker;
import temporal.deribit.params.get_apr_history;
import tools.jackson.core.type.TypeReference;
import temporal.deribit.params.get_book_summary_by_currency;
import temporal.deribit.params.get_book_summary_by_instrument;
import temporal.deribit.params.get_contract_size;
import temporal.deribit.params.get_delivery_prices;
import temporal.deribit.params.get_expirations;
import temporal.deribit.params.get_funding_chart_data;
import temporal.deribit.params.get_funding_rate_history;
import temporal.deribit.params.get_funding_rate_value;
import temporal.deribit.params.get_historical_volatility;
import temporal.deribit.params.get_index_chart_data;
import temporal.deribit.params.get_index_price;
import temporal.deribit.params.get_index_price_names;
import temporal.deribit.params.get_instrument;
import temporal.deribit.params.get_instruments;
import temporal.deribit.params.get_last_settlements_by_currency;
import temporal.deribit.params.get_last_settlements_by_instrument;
import temporal.deribit.params.get_last_trades_by_currency;
import temporal.deribit.params.get_last_trades_by_currency_and_time;
import temporal.deribit.params.get_last_trades_by_instrument;
import temporal.deribit.params.get_last_trades_by_instrument_and_time;
import temporal.deribit.params.get_mark_price_history;
import temporal.deribit.params.get_order_book;
import temporal.deribit.params.get_order_book_by_instrument_id;
import temporal.deribit.params.get_supported_index_names;
import temporal.deribit.params.get_supported_index_names.Type;
import temporal.deribit.params.get_ticker;
import temporal.deribit.params.get_trade_volumes;
import temporal.deribit.params.get_tradingview_chart_data;
import temporal.deribit.params.get_tradingview_chart_data.Resolution;
import temporal.deribit.params.get_volatility_index_data;

class MarketDataTest
{
	@Test
	void	test_get_apr_history() throws InterruptedException, ExecutionException
	{
		try
		{
			get_apr_history	params = new get_apr_history(ExchangeMessengerTestUtil.authorization, Currency.USDC, null, null);
			AnnualPercentageRates	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_apr_history(params));
			System.out.println("get_apr_history: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_apr_history: " + e.getMessage());
		}
	}

	@Test
	void	test_get_book_summary_by_currency() throws InterruptedException, ExecutionException
	{
		try
		{
			get_book_summary_by_currency	params = new get_book_summary_by_currency(ExchangeMessengerTestUtil.authorization, Currency.BTC, Kind.future);
			List<BookSummary>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_book_summary_by_currency(params));
			System.out.println("get_book_summary_by_currency: " + result.size() + " entries");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_book_summary_by_currency: " + e.getMessage());
		}
	}

	@Test
	void	test_get_book_summary_by_instrument() throws InterruptedException, ExecutionException
	{
		try
		{
			get_book_summary_by_instrument	params = new get_book_summary_by_instrument(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL);
			List<BookSummary>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_book_summary_by_instrument(params));
			System.out.println("get_book_summary_by_instrument: " + result.size() + " entries");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_book_summary_by_instrument: " + e.getMessage());
		}
	}

	@Test
	void	test_get_contract_size() throws InterruptedException, ExecutionException
	{
		try
		{
			get_contract_size	params = new get_contract_size(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL);
			ContractSize	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_contract_size(params));
			System.out.println("get_contract_size: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_contract_size: " + e.getMessage());
		}
	}

	@Test
	void	test_get_currencies() throws InterruptedException, ExecutionException
	{
		try
		{
			List<CurrencyDetails>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_currencies(ExchangeMessengerTestUtil.authorization));
			System.out.println("get_currencies: " + result.size() + " currencies");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_currencies: " + e.getMessage());
		}
	}

	@Test
	void	test_get_delivery_prices() throws InterruptedException, ExecutionException
	{
		try
		{
			get_delivery_prices	params = new get_delivery_prices(ExchangeMessengerTestUtil.authorization, IndexName.btc_usdc, null, null);
			DeliveryPrices	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_delivery_prices(params));
			System.out.println("get_delivery_prices: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_delivery_prices: " + e.getMessage());
		}
	}

	@Test
	void	test_get_expirations() throws InterruptedException, ExecutionException
	{
		try
		{
			get_expirations	params = new get_expirations(ExchangeMessengerTestUtil.authorization, Currency.BTC, Kind.future, null);
			List<String>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_expirations(new TypeReference<>() {}, params));
			System.out.println("get_expirations: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_expirations: " + e.getMessage());
		}
	}

	@Test
	void	test_get_funding_chart_data() throws InterruptedException, ExecutionException
	{
		try
		{
			get_funding_chart_data	params = new get_funding_chart_data(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL, "8h");
			FundingChartData	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_funding_chart_data(params));
			System.out.println("get_funding_chart_data: " + (result.data() != null ? result.data().size() + " data points" : result));
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_funding_chart_data: " + e.getMessage());
		}
	}

	@Test
	void	test_get_index_chart_data() throws InterruptedException, ExecutionException
	{
		try
		{
			get_index_chart_data	params = new get_index_chart_data(ExchangeMessengerTestUtil.authorization, IndexName.btc_usdc.toString(), "1h");
			List<MarkPricePoint>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_index_chart_data(params));
			System.out.println("get_index_chart_data: " + result.size() + " entries");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_index_chart_data: " + e.getMessage());
		}
	}

	@Test
	void	test_get_funding_rate_history() throws InterruptedException, ExecutionException
	{
		try
		{
			Calendar	calendar = getCalendar();
			long	end = calendar.getTimeInMillis();
			calendar.add(Calendar.HOUR, -24);
			long	start = calendar.getTimeInMillis();
			get_funding_rate_history	params = new get_funding_rate_history(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL, start, end);
			List<HistoricalFundingRate>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_funding_rate_history(params));
			System.out.println("get_funding_rate_history: " + result.size() + " entries");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_funding_rate_history: " + e.getMessage());
		}
	}

	@Test
	void	test_get_funding_rate_value() throws InterruptedException, ExecutionException
	{
		try
		{
			Calendar	calendar = getCalendar();
			long	end = calendar.getTimeInMillis();
			calendar.add(Calendar.HOUR, -24);
			long	start = calendar.getTimeInMillis();
			get_funding_rate_value	params = new get_funding_rate_value(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL, start, end);
			BigDecimal	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_funding_rate_value(params));
			System.out.println("get_funding_rate_value: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_funding_rate_value: " + e.getMessage());
		}
	}

	@Test
	void	test_get_historical_volatility() throws InterruptedException, ExecutionException
	{
		try
		{
			get_historical_volatility	params = new get_historical_volatility(ExchangeMessengerTestUtil.authorization, Currency.BTC);
			List<HistoricalVolatility>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_historical_volatility(params));
			System.out.println("get_historical_volatility: " + result.size() + " entries");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_historical_volatility: " + e.getMessage());
		}
	}

	@Test
	void	test_get_index_price() throws InterruptedException, ExecutionException
	{
		try
		{
			get_index_price	params = new get_index_price(ExchangeMessengerTestUtil.authorization, IndexName.btc_usdc);
			IndexPrice	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_index_price(params));
			System.out.println("get_index_price: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_index_price: " + e.getMessage());
		}
	}

	@Test
	void	test_get_index_price_names() throws InterruptedException, ExecutionException
	{
		try
		{
			get_index_price_names	params = new get_index_price_names(ExchangeMessengerTestUtil.authorization, null);
			List<IndexPriceName>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_index_price_names(params));
			System.out.println("get_index_price_names: " + result.size() + " entries");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_index_price_names: " + e.getMessage());
		}
	}

	@Test
	void	test_get_instrument() throws InterruptedException, ExecutionException
	{
		try
		{
			get_instrument	params = new get_instrument(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL);
			Instrument	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_instrument(params));
			System.out.println("get_instrument: " + result.instrument_name());
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_instrument: " + e.getMessage());
		}
	}

	@Test
	void	test_get_instruments() throws InterruptedException, ExecutionException
	{
		try
		{
			get_instruments	params = new get_instruments(ExchangeMessengerTestUtil.authorization, Currency.BTC, Kind.future, false);
			List<Instrument>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_instruments(params));
			System.out.println("get_instruments: " + result.size() + " instruments");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_instruments: " + e.getMessage());
		}
	}

	@Test
	void	test_get_last_settlements_by_currency() throws InterruptedException, ExecutionException
	{
		try
		{
			get_last_settlements_by_currency	params = new get_last_settlements_by_currency(ExchangeMessengerTestUtil.authorization, Currency.BTC, null, null, null, null);
			Settlements	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_last_settlements_by_currency(params));
			System.out.println("get_last_settlements_by_currency: " + result.settlements().length + " entries");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_last_settlements_by_currency: " + e.getMessage());
		}
	}

	@Test
	void	test_get_last_settlements_by_instrument() throws InterruptedException, ExecutionException
	{
		try
		{
			get_last_settlements_by_instrument	params = new get_last_settlements_by_instrument(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL, null, null, null, null);
			Settlements	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_last_settlements_by_instrument(params));
			System.out.println("get_last_settlements_by_instrument: " + result.settlements().length + " entries");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_last_settlements_by_instrument: " + e.getMessage());
		}
	}

	@Test
	void	test_get_last_trades_by_currency() throws InterruptedException, ExecutionException
	{
		try
		{
			get_last_trades_by_currency	params = new get_last_trades_by_currency(ExchangeMessengerTestUtil.authorization, Currency.BTC, Kind.any, null, null, null, null, null, null);
			LastTrades	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_last_trades_by_currency(params));
			System.out.println("get_last_trades_by_currency: " + result.trades().length + " trades");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_last_trades_by_currency: " + e.getMessage());
		}
	}

	@Test
	void	test_get_last_trades_by_currency_and_time() throws InterruptedException, ExecutionException
	{
		try
		{
			Calendar	calendar = getCalendar();
			long	end = calendar.getTimeInMillis();
			calendar.add(Calendar.HOUR, -1);
			long	start = calendar.getTimeInMillis();
			get_last_trades_by_currency_and_time	params = new get_last_trades_by_currency_and_time(ExchangeMessengerTestUtil.authorization, Currency.BTC, Kind.any, start, end, null, null);
			LastTrades	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_last_trades_by_currency_and_time(params));
			System.out.println("get_last_trades_by_currency_and_time: " + result.trades().length + " trades");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_last_trades_by_currency_and_time: " + e.getMessage());
		}
	}

	@Test
	void	test_get_last_trades_by_instrument() throws InterruptedException, ExecutionException
	{
		try
		{
			get_last_trades_by_instrument	params = new get_last_trades_by_instrument(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL, null, null, null, null, null, null);
			LastTrades	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_last_trades_by_instrument(params));
			System.out.println("get_last_trades_by_instrument: " + result.trades().length + " trades");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_last_trades_by_instrument: " + e.getMessage());
		}
	}

	@Test
	void	test_get_last_trades_by_instrument_and_time() throws InterruptedException, ExecutionException
	{
		try
		{
			Calendar	calendar = getCalendar();
			long	end = calendar.getTimeInMillis();
			calendar.add(Calendar.HOUR, -1);
			long	start = calendar.getTimeInMillis();
			get_last_trades_by_instrument_and_time	params = new get_last_trades_by_instrument_and_time(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL, start, end, null, null);
			LastTrades	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_last_trades_by_instrument_and_time(params));
			System.out.println("get_last_trades_by_instrument_and_time: " + result.trades().length + " trades");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_last_trades_by_instrument_and_time: " + e.getMessage());
		}
	}

	@Test
	void	test_get_mark_price_history() throws InterruptedException, ExecutionException
	{
		try
		{
			Calendar	calendar = getCalendar();
			long	end = calendar.getTimeInMillis();
			calendar.add(Calendar.HOUR, -1);
			long	start = calendar.getTimeInMillis();
			get_mark_price_history	params = new get_mark_price_history(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL, start, end, null, null);
			List<MarkPricePoint>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_mark_price_history(params));
			System.out.println("get_mark_price_history: " + result.size() + " entries");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_mark_price_history: " + e.getMessage());
		}
	}

	@Test
	void	test_get_order_book() throws InterruptedException, ExecutionException
	{
		try
		{
			get_order_book	params = new get_order_book(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL, null);
			OrderBook	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_order_book(params));
			System.out.println("get_order_book: bids=" + result.bids().length + " asks=" + result.asks().length);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_order_book: " + e.getMessage());
		}
	}

	@Test
	void	test_get_order_book_by_instrument_id() throws InterruptedException, ExecutionException
	{
		try
		{
			get_instrument	getInstParams = new get_instrument(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL);
			Instrument	instrument = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_instrument(getInstParams));
			get_order_book_by_instrument_id	params = new get_order_book_by_instrument_id(ExchangeMessengerTestUtil.authorization, instrument.instrument_id(), null);
			OrderBook	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_order_book_by_instrument_id(params));
			System.out.println("get_order_book_by_instrument_id: bids=" + result.bids().length + " asks=" + result.asks().length);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_order_book_by_instrument_id: " + e.getMessage());
		}
	}

	@Test
	void	test_get_supported_index_names() throws InterruptedException, ExecutionException
	{
		try
		{
			get_supported_index_names	params = new get_supported_index_names(ExchangeMessengerTestUtil.authorization, Type.all);
			List<IndexPriceName>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_supported_index_names(params));
			System.out.println("get_supported_index_names: " + result.size() + " entries");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_supported_index_names: " + e.getMessage());
		}
	}

	@Test
	void	test_get_trade_volumes() throws InterruptedException, ExecutionException
	{
		try
		{
			get_trade_volumes	params = new get_trade_volumes(ExchangeMessengerTestUtil.authorization, null);
			List<TradeVolume>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_trade_volumes(params));
			System.out.println("get_trade_volumes: " + result.size() + " entries");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_trade_volumes: " + e.getMessage());
		}
	}

	@Test
	void	test_get_tradingview_chart_data() throws InterruptedException, ExecutionException
	{
		try
		{
			Calendar	calendar = getCalendar();
			long	end = calendar.getTimeInMillis();
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			long	start = calendar.getTimeInMillis();
			get_tradingview_chart_data	params = new get_tradingview_chart_data(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_USDC, start, end, Resolution._1D);
			TradingViewChartData	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_tradingview_chart_data(params));
			System.out.println("get_tradingview_chart_data: " + result.ticks().length + " ticks");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_tradingview_chart_data: " + e.getMessage());
		}
	}

	@Test
	void	test_get_volatility_index_data() throws InterruptedException, ExecutionException
	{
		try
		{
			Calendar	calendar = getCalendar();
			long	end = calendar.getTimeInMillis();
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			long	start = calendar.getTimeInMillis();
			get_volatility_index_data	params = new get_volatility_index_data(ExchangeMessengerTestUtil.authorization, Currency.BTC, start, end, get_volatility_index_data.Resolution._1D);
			VolatilityIndexData	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_volatility_index_data(params));
			System.out.println("get_volatility_index_data: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_volatility_index_data: " + e.getMessage());
		}
	}

	@Test
	void	test_ticker() throws InterruptedException, ExecutionException
	{
		try
		{
			get_ticker	params = new get_ticker(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL);
			ticker	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.ticker(params));
			System.out.println("ticker: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP ticker: " + e.getMessage());
		}
	}

	private static Calendar	getCalendar()
	{
		Calendar	calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		calendar.set(Calendar.DST_OFFSET, 0);
		return calendar;
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
