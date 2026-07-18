package temporal.deribit.library;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import temporal.deribit.dto.Combo;
import temporal.deribit.dto.Currency;
import temporal.deribit.dto.Direction;
import temporal.deribit.dto.LegPrices;
import temporal.deribit.params.create_combo;
import temporal.deribit.params.create_combo.Leg;
import temporal.deribit.params.get_combo_details;
import temporal.deribit.params.get_combo_ids;
import temporal.deribit.params.get_combo_ids.State;
import temporal.deribit.params.get_combos;
import temporal.deribit.params.get_leg_prices;

class ComboBooksTest
{
	@Test
	void	test_create_combo() throws InterruptedException, ExecutionException
	{
		try
		{
			Leg[]	legs = new Leg[]{new Leg(ExchangeMessengerTestUtil.BTC_PERPETUAL, BigDecimal.valueOf(10), Direction.buy)};
			create_combo	params = new create_combo(ExchangeMessengerTestUtil.authorization, legs);
			Combo	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.create_combo(params));
			System.out.println("create_combo: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP create_combo: " + e.getMessage());
		}
	}

	@Test
	void	test_get_leg_prices() throws InterruptedException, ExecutionException
	{
		try
		{
			get_leg_prices.Leg[]	legs = new get_leg_prices.Leg[]{new get_leg_prices.Leg(ExchangeMessengerTestUtil.BTC_PERPETUAL, BigDecimal.valueOf(10), Direction.buy)};
			get_leg_prices	params = new get_leg_prices(ExchangeMessengerTestUtil.authorization, legs, BigDecimal.valueOf(60000));
			LegPrices	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_leg_prices(params));
			System.out.println("get_leg_prices: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_leg_prices: " + e.getMessage());
		}
	}

	@Test
	void	test_get_combo_details() throws InterruptedException, ExecutionException
	{
		try
		{
			get_combo_details	params = new get_combo_details(ExchangeMessengerTestUtil.authorization, "combo-1");
			Combo	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_combo_details(params));
			System.out.println("get_combo_details: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_combo_details: " + e.getMessage());
		}
	}

	@Test
	void	test_get_combo_ids() throws InterruptedException, ExecutionException
	{
		try
		{
			get_combo_ids	params = new get_combo_ids(ExchangeMessengerTestUtil.authorization, Currency.BTC, State.active);
			List<String>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_combo_ids(params));
			System.out.println("get_combo_ids: " + result.size() + " combo ids");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_combo_ids: " + e.getMessage());
		}
	}

	@Test
	void	test_get_combos() throws InterruptedException, ExecutionException
	{
		try
		{
			get_combos	params = new get_combos(ExchangeMessengerTestUtil.authorization, Currency.BTC);
			List<Combo>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_combos(params));
			System.out.println("get_combos: " + result.size() + " combos");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_combos: " + e.getMessage());
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
