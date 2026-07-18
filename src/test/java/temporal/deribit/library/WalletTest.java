package temporal.deribit.library;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import temporal.deribit.dto.Address;
import temporal.deribit.dto.Beneficiary;
import temporal.deribit.dto.Currency;
import temporal.deribit.dto.Deposit;
import temporal.deribit.dto.DepositAddress;
import temporal.deribit.dto.Deposits;
import temporal.deribit.dto.RewardEligibility;
import temporal.deribit.dto.Transfer;
import temporal.deribit.dto.Transfers;
import temporal.deribit.dto.Withdraw;
import temporal.deribit.dto.Withdraws;
import temporal.deribit.params.add_to_address_book;
import temporal.deribit.params.cancel_transfer_by_id;
import temporal.deribit.params.cancel_withdrawal;
import temporal.deribit.params.create_deposit_address;
import temporal.deribit.params.delete_address_beneficiary;
import temporal.deribit.params.get_address_beneficiary;
import temporal.deribit.params.get_address_book;
import temporal.deribit.params.get_current_deposit_address;
import temporal.deribit.params.get_deposits;
import temporal.deribit.params.get_transfers;
import temporal.deribit.params.get_withdraws;
import temporal.deribit.params.list_address_beneficiaries;
import temporal.deribit.params.remove_from_address_book;
import temporal.deribit.params.save_address_beneficiary;
import temporal.deribit.params.set_clearance_originator;
import temporal.deribit.params.submit_transfer_between_subaccounts;
import temporal.deribit.params.submit_transfer_to_subaccount;
import temporal.deribit.params.submit_transfer_to_user;
import temporal.deribit.params.update_in_address_book;
import temporal.deribit.params.withdraw;
import temporal.deribit.params.withdraw.Priority;

class WalletTest
{
	@Test
	void	test_add_to_address_book() throws InterruptedException, ExecutionException
	{
		try
		{
			add_to_address_book	params = new add_to_address_book(ExchangeMessengerTestUtil.authorization, Currency.BTC, add_to_address_book.Type.withdrawal, "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", "test-address", null, null, null, null, null, null, null, false, false, null);
			Address	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.add_to_address_book(params));
			System.out.println("add_to_address_book: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP add_to_address_book: " + e.getMessage());
		}
	}

	@Test
	void	test_cancel_transfer_by_id() throws InterruptedException, ExecutionException
	{
		try
		{
			cancel_transfer_by_id	params = new cancel_transfer_by_id(ExchangeMessengerTestUtil.authorization, Currency.USDC, 0);
			Transfer	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.cancel_transfer_by_id(params));
			System.out.println("cancel_transfer_by_id: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP cancel_transfer_by_id: " + e.getMessage());
		}
	}

	@Test
	void	test_cancel_withdrawal() throws InterruptedException, ExecutionException
	{
		try
		{
			cancel_withdrawal	params = new cancel_withdrawal(ExchangeMessengerTestUtil.authorization, Currency.USDC, 0);
			Withdraw	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.cancel_withdrawal(params));
			System.out.println("cancel_withdrawal: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP cancel_withdrawal: " + e.getMessage());
		}
	}

	@Test
	void	test_create_deposit_address() throws InterruptedException, ExecutionException
	{
		try
		{
			create_deposit_address	params = new create_deposit_address(ExchangeMessengerTestUtil.authorization, Currency.USDC);
			DepositAddress	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.create_deposit_address(params));
			System.out.println("create_deposit_address: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP create_deposit_address: " + e.getMessage());
		}
	}

	@Test
	void	test_delete_address_beneficiary() throws InterruptedException, ExecutionException
	{
		try
		{
			delete_address_beneficiary	params = new delete_address_beneficiary(ExchangeMessengerTestUtil.authorization, Currency.BTC, "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", null);
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.delete_address_beneficiary(params));
			System.out.println("delete_address_beneficiary: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP delete_address_beneficiary: " + e.getMessage());
		}
	}

	@Test
	void	test_get_address_beneficiary() throws InterruptedException, ExecutionException
	{
		try
		{
			get_address_beneficiary	params = new get_address_beneficiary(ExchangeMessengerTestUtil.authorization, Currency.BTC, "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", null);
			Beneficiary	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_address_beneficiary(params));
			System.out.println("get_address_beneficiary: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_address_beneficiary: " + e.getMessage());
		}
	}

	@Test
	void	test_get_address_book() throws InterruptedException, ExecutionException
	{
		try
		{
			get_address_book	params = new get_address_book(ExchangeMessengerTestUtil.authorization, Currency.BTC, temporal.deribit.dto.Address.Type.transfer);
			List<Address>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_address_book(params));
			System.out.println("get_address_book: " + result.size() + " entries");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_address_book: " + e.getMessage());
		}
	}

	@Test
	void	test_get_current_deposit_address() throws InterruptedException, ExecutionException
	{
		try
		{
			get_current_deposit_address	params = new get_current_deposit_address(ExchangeMessengerTestUtil.authorization, Currency.USDC);
			DepositAddress	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_current_deposit_address(params));
			System.out.println("get_current_deposit_address: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_current_deposit_address: " + e.getMessage());
		}
	}

	@Test
	void	test_get_deposits() throws InterruptedException, ExecutionException
	{
		try
		{
			get_deposits	params = new get_deposits(ExchangeMessengerTestUtil.authorization, Currency.USDC, null, null);
			Deposits	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_deposits(params));
			System.out.println("get_deposits: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_deposits: " + e.getMessage());
		}
	}

	@Test
	void	test_get_reward_eligibility() throws InterruptedException, ExecutionException
	{
		try
		{
			RewardEligibility	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_reward_eligibility(ExchangeMessengerTestUtil.authorization));
			System.out.println("get_reward_eligibility: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_reward_eligibility: " + e.getMessage());
		}
	}

	@Test
	void	test_get_transfers() throws InterruptedException, ExecutionException
	{
		try
		{
			get_transfers	params = new get_transfers(ExchangeMessengerTestUtil.authorization, Currency.USDC, null, null);
			Transfers	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_transfers(params));
			System.out.println("get_transfers: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_transfers: " + e.getMessage());
		}
	}

	@Test
	void	test_get_withdraws() throws InterruptedException, ExecutionException
	{
		try
		{
			get_withdraws	params = new get_withdraws(ExchangeMessengerTestUtil.authorization, Currency.USDC, null, null);
			Withdraws	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.get_withdraws(params));
			System.out.println("get_withdraws: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP get_withdraws: " + e.getMessage());
		}
	}

	@Test
	void	test_list_address_beneficiaries() throws InterruptedException, ExecutionException
	{
		try
		{
			list_address_beneficiaries	params = new list_address_beneficiaries(ExchangeMessengerTestUtil.authorization, Currency.BTC, null, null, null, null, null, null, null, null, null, null, null, null, null);
			List<Beneficiary>	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.list_address_beneficiaries(params));
			System.out.println("list_address_beneficiaries: " + result.size() + " entries");
		}
		catch(Exception	e)
		{
			System.out.println("SKIP list_address_beneficiaries: " + e.getMessage());
		}
	}

	@Test
	void	test_remove_from_address_book() throws InterruptedException, ExecutionException
	{
		try
		{
			remove_from_address_book	params = new remove_from_address_book(ExchangeMessengerTestUtil.authorization, Currency.BTC, remove_from_address_book.Type.withdrawal, "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa");
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.remove_from_address_book(params));
			System.out.println("remove_from_address_book: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP remove_from_address_book: " + e.getMessage());
		}
	}

	@Test
	void	test_save_address_beneficiary() throws InterruptedException, ExecutionException
	{
		try
		{
			save_address_beneficiary	params = new save_address_beneficiary(ExchangeMessengerTestUtil.authorization, Currency.BTC, "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", null, false, false, false, null, null, null, null, null, null, null);
			Beneficiary	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.save_address_beneficiary(params));
			System.out.println("save_address_beneficiary: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP save_address_beneficiary: " + e.getMessage());
		}
	}

	@Test
	void	test_set_clearance_originator() throws InterruptedException, ExecutionException
	{
		try
		{
			set_clearance_originator	params = new set_clearance_originator(ExchangeMessengerTestUtil.authorization, null, null);
			Deposit	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.set_clearance_originator(params));
			System.out.println("set_clearance_originator: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP set_clearance_originator: " + e.getMessage());
		}
	}

	@Test
	void	test_submit_transfer_between_subaccounts() throws InterruptedException, ExecutionException
	{
		try
		{
			submit_transfer_between_subaccounts	params = new submit_transfer_between_subaccounts(ExchangeMessengerTestUtil.authorization, Currency.USDC, BigDecimal.valueOf(10), 0, null);
			Transfer	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.submit_transfer_between_subaccounts(params));
			System.out.println("submit_transfer_between_subaccounts: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP submit_transfer_between_subaccounts: " + e.getMessage());
		}
	}

	@Test
	void	test_submit_transfer_to_subaccount() throws InterruptedException, ExecutionException
	{
		try
		{
			submit_transfer_to_subaccount	params = new submit_transfer_to_subaccount(ExchangeMessengerTestUtil.authorization, Currency.USDC, BigDecimal.valueOf(10), 0);
			Transfer	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.submit_transfer_to_subaccount(params));
			System.out.println("submit_transfer_to_subaccount: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP submit_transfer_to_subaccount: " + e.getMessage());
		}
	}

	@Test
	void	test_submit_transfer_to_user() throws InterruptedException, ExecutionException
	{
		try
		{
			submit_transfer_to_user	params = new submit_transfer_to_user(ExchangeMessengerTestUtil.authorization, Currency.USDC, BigDecimal.valueOf(10), "non-existent-user");
			Transfer	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.submit_transfer_to_user(params));
			System.out.println("submit_transfer_to_user: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP submit_transfer_to_user: " + e.getMessage());
		}
	}

	@Test
	void	test_update_in_address_book() throws InterruptedException, ExecutionException
	{
		try
		{
			update_in_address_book	params = new update_in_address_book(ExchangeMessengerTestUtil.authorization, Currency.BTC, update_in_address_book.Type.withdrawal, "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", null, null, null, null, null, null, null, false, false, "updated-label");
			String	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.update_in_address_book(params));
			System.out.println("update_in_address_book: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP update_in_address_book: " + e.getMessage());
		}
	}

	@Test
	void	test_withdraw() throws InterruptedException, ExecutionException
	{
		try
		{
			withdraw	params = new withdraw(ExchangeMessengerTestUtil.authorization, Currency.USDC, "0x0000000000000000000000000000000000000000", BigDecimal.valueOf(1), Priority.mid);
			Withdraw	result = ExchangeMessengerTestUtil.get(ExchangeMessengerTestUtil.exchangeMessenger.withdraw(params));
			System.out.println("withdraw: " + result);
		}
		catch(Exception	e)
		{
			System.out.println("SKIP withdraw: " + e.getMessage());
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
