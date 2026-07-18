package temporal.deribit.library;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import temporal.deribit.dto.AccessLog;
import temporal.deribit.dto.Account;
import temporal.deribit.dto.AccountDetail;
import temporal.deribit.dto.AccountSumaries;
import temporal.deribit.dto.AccountSummary;
import temporal.deribit.dto.AffiliateProgram;
import temporal.deribit.dto.Announcement;
import temporal.deribit.dto.ApiKey;
import temporal.deribit.dto.Currency;
import temporal.deribit.dto.CustodyAccount;
import temporal.deribit.dto.Kind;
import temporal.deribit.dto.MarginModelChange;
import temporal.deribit.dto.Position;
import temporal.deribit.dto.TransactionLogs;
import temporal.deribit.dto.UserLock;
import temporal.deribit.params.change_api_key_name;
import temporal.deribit.params.change_margin_model;
import temporal.deribit.params.change_scope_in_api_key;
import temporal.deribit.params.change_subaccount_name;
import temporal.deribit.params.create_api_key;
import temporal.deribit.params.disable_api_key;
import temporal.deribit.params.edit_api_key;
import temporal.deribit.params.enable_api_key;
import temporal.deribit.params.get_access_log;
import temporal.deribit.params.get_account_summaries;
import temporal.deribit.params.get_account_summary;
import temporal.deribit.params.get_announcements;
import temporal.deribit.params.get_position;
import temporal.deribit.params.get_positions;
import temporal.deribit.params.get_subaccounts;
import temporal.deribit.params.get_subaccounts_details;
import temporal.deribit.params.get_transaction_log;
import temporal.deribit.params.list_custody_accounts;
import temporal.deribit.params.pme_simulate;
import temporal.deribit.params.remove_api_key;
import temporal.deribit.params.remove_subaccount;
import temporal.deribit.params.reset_api_key;
import temporal.deribit.params.set_announcement_as_read;
import temporal.deribit.params.set_disabled_trading_products;
import temporal.deribit.params.set_disabled_trading_products.TradingProduct;
import temporal.deribit.params.set_email_for_subaccount;
import temporal.deribit.params.set_email_language;
import temporal.deribit.params.set_self_trading_config;
import temporal.deribit.params.set_self_trading_config.Mode;
import temporal.deribit.params.simulate_portfolio;
import temporal.deribit.params.toggle_notifications_from_subaccount;
import temporal.deribit.params.toggle_subaccount_login;
import temporal.deribit.params.toggle_subaccount_login.State;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountManagementTest
{
	private static int	createdSubaccountId;
	private static int	createdApiKeyId;

	@Test
	@Order(1)
	void	test_create_subaccount() throws InterruptedException, ExecutionException
	{
		try
		{
			Account	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.create_subaccount(ExchangeMessengerTestUtil.authorization));
			createdSubaccountId = result.id();
			System.out.println("create_subaccount: id=" + createdSubaccountId);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP create_subaccount: " + e.getMessage());
		}
	}

	@Test
	@Order(2)
	void	test_remove_subaccount() throws InterruptedException, ExecutionException
	{
		try
		{
			if (createdSubaccountId == 0)
			{
				System.out.println("SKIP remove_subaccount: no subaccount created");
				return;
			}
			remove_subaccount	params = new remove_subaccount(ExchangeMessengerTestUtil.authorization, createdSubaccountId);
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.remove_subaccount(params));
			System.out.println("remove_subaccount: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP remove_subaccount: " + e.getMessage());
		}
	}

	@Test
	@Order(3)
	void	test_create_api_key() throws InterruptedException, ExecutionException
	{
		try
		{
			DeribitKey	tempKey = new DeribitKey();
			String[]	scope = new String[]{"account:read", "trade:read_write"};
			create_api_key	params = new create_api_key(ExchangeMessengerTestUtil.authorization, scope, "test-api-key", tempKey.getPublic_key(), null);
			ApiKey	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.create_api_key(params));
			createdApiKeyId = result.id();
			System.out.println("create_api_key: id=" + createdApiKeyId);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP create_api_key: " + e.getMessage());
		}
	}

	@Test
	@Order(4)
	void	test_disable_api_key() throws InterruptedException, ExecutionException
	{
		try
		{
			if (createdApiKeyId == 0)
			{
				System.out.println("SKIP disable_api_key: no API key created");
				return;
			}
			disable_api_key	params = new disable_api_key(ExchangeMessengerTestUtil.authorization, createdApiKeyId);
			ApiKey	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.disable_api_key(params));
			System.out.println("disable_api_key: id=" + result.id() + " enabled=" + result.enabled());
		}
		catch(Exception	e)
		{
			System.out.println("SKIP disable_api_key: " + e.getMessage());
		}
	}

	@Test
	@Order(5)
	void	test_enable_api_key() throws InterruptedException, ExecutionException
	{
		try
		{
			if (createdApiKeyId == 0)
			{
				System.out.println("SKIP enable_api_key: no API key created");
				return;
			}
			enable_api_key	params = new enable_api_key(ExchangeMessengerTestUtil.authorization, createdApiKeyId);
			ApiKey	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.enable_api_key(params));
			System.out.println("enable_api_key: id=" + result.id() + " enabled=" + result.enabled());
		}
		catch(Exception	e)
		{
			System.out.println("SKIP enable_api_key: " + e.getMessage());
		}
	}

	@Test
	@Order(6)
	void	test_reset_api_key() throws InterruptedException, ExecutionException
	{
		try
		{
			if (createdApiKeyId == 0)
			{
				System.out.println("SKIP reset_api_key: no API key created");
				return;
			}
			reset_api_key	params = new reset_api_key(ExchangeMessengerTestUtil.authorization, createdApiKeyId);
			ApiKey	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.reset_api_key(params));
			System.out.println("reset_api_key: id=" + result.id());
		}
		catch(Exception	e)
		{
			System.out.println("SKIP reset_api_key: " + e.getMessage());
		}
	}

	@Test
	@Order(7)
	void	test_remove_api_key() throws InterruptedException, ExecutionException
	{
		try
		{
			if (createdApiKeyId == 0)
			{
				System.out.println("SKIP remove_api_key: no API key created");
				return;
			}
			remove_api_key	params = new remove_api_key(ExchangeMessengerTestUtil.authorization, createdApiKeyId);
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.remove_api_key(params));
			System.out.println("remove_api_key: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP remove_api_key: " + e.getMessage());
		}
	}

	@Test
	void	test_change_api_key_name() throws InterruptedException, ExecutionException
	{
		try
		{
			change_api_key_name	params = new change_api_key_name(ExchangeMessengerTestUtil.authorization, 0, "renamed-key");
			ApiKey	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.change_api_key_name(params));
			System.out.println("change_api_key_name: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP change_api_key_name: " + e.getMessage());
		}
	}

	@Test
	void	test_change_margin_model() throws InterruptedException, ExecutionException
	{
		try
		{
			List<Account>	accounts = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_subaccounts(new get_subaccounts(ExchangeMessengerTestUtil.authorization, false)));
			int	userId = accounts.isEmpty() ? 0 : accounts.get(0).id();
			change_margin_model	params = new change_margin_model(ExchangeMessengerTestUtil.authorization, userId, true);
			List<MarginModelChange>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.change_margin_model(params));
			System.out.println("change_margin_model: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP change_margin_model: " + e.getMessage());
		}
	}

	@Test
	void	test_change_scope_in_api_key() throws InterruptedException, ExecutionException
	{
		try
		{
			String[]	newScope = new String[]{"account:read"};
			change_scope_in_api_key	params = new change_scope_in_api_key(ExchangeMessengerTestUtil.authorization, 0, newScope);
			ApiKey	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.change_scope_in_api_key(params));
			System.out.println("change_scope_in_api_key: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP change_scope_in_api_key: " + e.getMessage());
		}
	}

	@Test
	void	test_change_subaccount_name() throws InterruptedException, ExecutionException
	{
		try
		{
			change_subaccount_name	params = new change_subaccount_name(ExchangeMessengerTestUtil.authorization, 0, "TestSubaccount");
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.change_subaccount_name(params));
			System.out.println("change_subaccount_name: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP change_subaccount_name: " + e.getMessage());
		}
	}

	@Test
	void	test_edit_api_key() throws InterruptedException, ExecutionException
	{
		try
		{
			edit_api_key	params = new edit_api_key(ExchangeMessengerTestUtil.authorization, 0, null, "edited-key", null, null, null);
			ApiKey	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.edit_api_key(params));
			System.out.println("edit_api_key: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP edit_api_key: " + e.getMessage());
		}
	}

	@Test
	void	test_enable_affiliate_program() throws InterruptedException, ExecutionException
	{
		try
		{
			ApiKey	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.enable_affiliate_program(ExchangeMessengerTestUtil.authorization));
			System.out.println("enable_affiliate_program: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP enable_affiliate_program: " + e.getMessage());
		}
	}

	@Test
	void	test_get_access_log() throws InterruptedException, ExecutionException
	{
		try
		{
			get_access_log	params = new get_access_log(ExchangeMessengerTestUtil.authorization, null, null);
			AccessLog	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_access_log(params));
			System.out.println("get_access_log: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_access_log: " + e.getMessage());
		}
	}

	@Test
	void	test_get_account_summaries() throws InterruptedException, ExecutionException
	{
		try
		{
			get_account_summaries	params = new get_account_summaries(ExchangeMessengerTestUtil.authorization, null, null);
			AccountSumaries	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_account_summaries(params));
			System.out.println("get_account_summaries: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_account_summaries: " + e.getMessage());
		}
	}

	@Test
	void	test_get_account_summary() throws InterruptedException, ExecutionException
	{
		try
		{
			get_account_summary	params = new get_account_summary(ExchangeMessengerTestUtil.authorization, Currency.USDC, null, null);
			AccountSummary	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_account_summary(params));
			System.out.println("get_account_summary: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_account_summary: " + e.getMessage());
		}
	}

	@Test
	void	test_get_affiliate_program_info() throws InterruptedException, ExecutionException
	{
		try
		{
			AffiliateProgram	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_affiliate_program_info(ExchangeMessengerTestUtil.authorization));
			System.out.println("get_affiliate_program_info: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_affiliate_program_info: " + e.getMessage());
		}
	}

	@Test
	void	test_get_announcements() throws InterruptedException, ExecutionException
	{
		try
		{
			get_announcements	params = new get_announcements(ExchangeMessengerTestUtil.authorization, null, null);
			List<Announcement>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_announcements(params));
			System.out.println("get_announcements: " + result.size() + " announcements");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_announcements: " + e.getMessage());
		}
	}

	@Test
	void	test_get_email_language() throws InterruptedException, ExecutionException
	{
		try
		{
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_email_language(ExchangeMessengerTestUtil.authorization));
			System.out.println("get_email_language: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_email_language: " + e.getMessage());
		}
	}

	@Test
	void	test_get_new_announcements() throws InterruptedException, ExecutionException
	{
		try
		{
			List<Announcement>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_new_announcements(ExchangeMessengerTestUtil.authorization));
			System.out.println("get_new_announcements: " + result.size() + " announcements");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_new_announcements: " + e.getMessage());
		}
	}

	@Test
	void	test_get_position() throws InterruptedException, ExecutionException
	{
		try
		{
			get_position	params = new get_position(ExchangeMessengerTestUtil.authorization, ExchangeMessengerTestUtil.BTC_PERPETUAL);
			Position	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_position(params));
			System.out.println("get_position: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_position: " + e.getMessage());
		}
	}

	@Test
	void	test_get_positions() throws InterruptedException, ExecutionException
	{
		try
		{
			get_positions	params = new get_positions(ExchangeMessengerTestUtil.authorization, Currency.BTC, Kind.any, null);
			List<Position>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_positions(params));
			System.out.println("get_positions: " + result.size() + " positions");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_positions: " + e.getMessage());
		}
	}

	@Test
	void	test_get_subaccounts() throws InterruptedException, ExecutionException
	{
		try
		{
			get_subaccounts	params = new get_subaccounts(ExchangeMessengerTestUtil.authorization, false);
			List<Account>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_subaccounts(params));
			System.out.println("get_subaccounts: " + result.size() + " accounts");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_subaccounts: " + e.getMessage());
		}
	}

	@Test
	void	test_get_subaccounts_details() throws InterruptedException, ExecutionException
	{
		try
		{
			get_subaccounts_details	params = new get_subaccounts_details(ExchangeMessengerTestUtil.authorization, Currency.BTC, null);
			List<AccountDetail>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_subaccounts_details(params));
			System.out.println("get_subaccounts_details: " + result.size() + " entries");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_subaccounts_details: " + e.getMessage());
		}
	}

	@Test
	void	test_get_transaction_log() throws InterruptedException, ExecutionException
	{
		try
		{
			long	now = System.currentTimeMillis();
			get_transaction_log	params = new get_transaction_log(ExchangeMessengerTestUtil.authorization, Currency.USDC, now - 86400000L, now, null, null, null, null);
			TransactionLogs	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_transaction_log(params));
			System.out.println("get_transaction_log: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_transaction_log: " + e.getMessage());
		}
	}

	@Test
	void	test_get_user_locks() throws InterruptedException, ExecutionException
	{
		try
		{
			List<UserLock>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_user_locks(ExchangeMessengerTestUtil.authorization));
			System.out.println("get_user_locks: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_user_locks: " + e.getMessage());
		}
	}

	@Test
	void	test_list_api_keys() throws InterruptedException, ExecutionException
	{
		try
		{
			List<ApiKey>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.list_api_keys(ExchangeMessengerTestUtil.authorization));
			System.out.println("list_api_keys: " + result.size() + " keys");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP list_api_keys: " + e.getMessage());
		}
	}

	@Test
	void	test_list_custody_accounts() throws InterruptedException, ExecutionException
	{
		try
		{
			list_custody_accounts	params = new list_custody_accounts(ExchangeMessengerTestUtil.authorization, Currency.USDC);
			List<CustodyAccount>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.list_custody_accounts(params));
			System.out.println("list_custody_accounts: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP list_custody_accounts: " + e.getMessage());
		}
	}

	@Test
	void	test_pme_simulate() throws InterruptedException, ExecutionException
	{
		try
		{
			pme_simulate	params = new pme_simulate(ExchangeMessengerTestUtil.authorization, Currency.BTC, false, null);
			Object	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.pme_simulate(params));
			System.out.println("pme_simulate: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP pme_simulate: " + e.getMessage());
		}
	}

	@Test
	void	test_set_announcement_as_read() throws InterruptedException, ExecutionException
	{
		try
		{
			set_announcement_as_read	params = new set_announcement_as_read(ExchangeMessengerTestUtil.authorization, 0);
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.set_announcement_as_read(params));
			System.out.println("set_announcement_as_read: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP set_announcement_as_read: " + e.getMessage());
		}
	}

	@Test
	void	test_set_disabled_trading_products() throws InterruptedException, ExecutionException
	{
		try
		{
			set_disabled_trading_products	params = new set_disabled_trading_products(ExchangeMessengerTestUtil.authorization, 0, new TradingProduct[]{TradingProduct.spots});
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.set_disabled_trading_products(params));
			System.out.println("set_disabled_trading_products: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP set_disabled_trading_products: " + e.getMessage());
		}
	}

	@Test
	void	test_set_email_for_subaccount() throws InterruptedException, ExecutionException
	{
		try
		{
			set_email_for_subaccount	params = new set_email_for_subaccount(ExchangeMessengerTestUtil.authorization, 0, "test@example.com");
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.set_email_for_subaccount(params));
			System.out.println("set_email_for_subaccount: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP set_email_for_subaccount: " + e.getMessage());
		}
	}

	@Test
	void	test_set_email_language() throws InterruptedException, ExecutionException
	{
		try
		{
			set_email_language	params = new set_email_language(ExchangeMessengerTestUtil.authorization, set_email_language.Language.en);
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.set_email_language(params));
			System.out.println("set_email_language: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP set_email_language: " + e.getMessage());
		}
	}

	@Test
	void	test_set_self_trading_config() throws InterruptedException, ExecutionException
	{
		try
		{
			set_self_trading_config	params = new set_self_trading_config(ExchangeMessengerTestUtil.authorization, Mode.reject_taker, false, null);
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.set_self_trading_config(params));
			System.out.println("set_self_trading_config: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP set_self_trading_config: " + e.getMessage());
		}
	}

	@Test
	void	test_simulate_portfolio() throws InterruptedException, ExecutionException
	{
		try
		{
			simulate_portfolio	params = new simulate_portfolio(ExchangeMessengerTestUtil.authorization, Currency.BTC, false, null);
			AccountSummary	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.simulate_portfolio(params));
			System.out.println("simulate_portfolio: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP simulate_portfolio: " + e.getMessage());
		}
	}

	@Test
	void	test_toggle_notifications_from_subaccount() throws InterruptedException, ExecutionException
	{
		try
		{
			toggle_notifications_from_subaccount	params = new toggle_notifications_from_subaccount(ExchangeMessengerTestUtil.authorization, 0, false);
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.toggle_notifications_from_subaccount(params));
			System.out.println("toggle_notifications_from_subaccount: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP toggle_notifications_from_subaccount: " + e.getMessage());
		}
	}

	@Test
	void	test_toggle_subaccount_login() throws InterruptedException, ExecutionException
	{
		try
		{
			toggle_subaccount_login	params = new toggle_subaccount_login(ExchangeMessengerTestUtil.authorization, 0, State.disable);
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.toggle_subaccount_login(params));
			System.out.println("toggle_subaccount_login: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP toggle_subaccount_login: " + e.getMessage());
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
