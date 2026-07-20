package temporal.deribit.library;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Future;

import temporal.deribit.dto.AccessLog;
import temporal.deribit.dto.Account;
import temporal.deribit.dto.AccountDetail;
import temporal.deribit.dto.AccountSumaries;
import temporal.deribit.dto.AccountSummary;
import temporal.deribit.dto.Address;
import temporal.deribit.dto.AffiliateProgram;
import temporal.deribit.dto.Announcement;
import temporal.deribit.dto.AnnualPercentageRates;
import temporal.deribit.dto.ApiKey;
import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Beneficiary;
import temporal.deribit.dto.BlockRfq;
import temporal.deribit.dto.BlockRfqTrades;
import temporal.deribit.dto.BlockRfqUserInfo;
import temporal.deribit.dto.BlockTrade;
import temporal.deribit.dto.BlockTradeRequest;
import temporal.deribit.dto.BlockTradeSignature;
import temporal.deribit.dto.BookSummary;
import temporal.deribit.dto.BrokerClient;
import temporal.deribit.dto.CancelOnDisconnect;
import temporal.deribit.dto.Combo;
import temporal.deribit.dto.ContractSize;
import temporal.deribit.dto.CurrencyDetails;
import temporal.deribit.dto.CustodyAccount;
import temporal.deribit.dto.DeliveryPrices;
import temporal.deribit.dto.Deposit;
import temporal.deribit.dto.DepositAddress;
import temporal.deribit.dto.Deposits;
import temporal.deribit.dto.FundingChartData;
import temporal.deribit.dto.Hello;
import temporal.deribit.dto.HistoricalFundingRate;
import temporal.deribit.dto.HistoricalVolatility;
import temporal.deribit.dto.IndexPrice;
import temporal.deribit.dto.IndexPriceName;
import temporal.deribit.dto.Instrument;
import temporal.deribit.dto.LastTrades;
import temporal.deribit.dto.LegPrices;
import temporal.deribit.dto.Margin;
import temporal.deribit.dto.MarginModelChange;
import temporal.deribit.dto.MarkPricePoint;
import temporal.deribit.dto.MarketMakerProtectionConfig;
import temporal.deribit.dto.MarketMakerProtectionStatus;
import temporal.deribit.dto.MassQuote;
import temporal.deribit.dto.Order;
import temporal.deribit.dto.OrderBook;
import temporal.deribit.dto.OrderMargin;
import temporal.deribit.dto.OrderResponse;
import temporal.deribit.dto.Orders;
import temporal.deribit.dto.Position;
import temporal.deribit.dto.PositionClose;
import temporal.deribit.dto.PositionMove;
import temporal.deribit.dto.Response;
import temporal.deribit.dto.RewardEligibility;
import temporal.deribit.dto.Settlements;
import temporal.deribit.dto.Status;
import temporal.deribit.dto.TestResult;
import temporal.deribit.dto.TradeVolume;
import temporal.deribit.dto.Trades;
import temporal.deribit.dto.TradingViewChartData;
import temporal.deribit.dto.TransactionLogs;
import temporal.deribit.dto.Transfer;
import temporal.deribit.dto.Transfers;
import temporal.deribit.dto.UserLock;
import temporal.deribit.dto.VolatilityIndexData;
import temporal.deribit.dto.Withdraw;
import temporal.deribit.dto.Withdraws;
import temporal.deribit.notifications.ticker;
import temporal.deribit.params.*;
import tools.jackson.core.type.TypeReference;

public class ExchangeMessenger
{
	public ExchangeMessenger(MessageReader	messageReader, MessageWriter	messageWriter)
	{
		this.messageReader = messageReader;
		this.messageWriter = messageWriter;
	}

	/*
	 * Authentication.
	 */
	public Future<Authorization>	auth(auth	params)
	{
		Request<auth>	request = new Request<>("public/auth", params);
		FutureResponse<Authorization>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Authorization>	exchange_token(exchange_token	params)
	{
		Request<exchange_token>	request = new Request<>("private/exchange_token", params);
		FutureResponse<Authorization>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Authorization>	fork_token(fork_token	params)
	{
		Request<fork_token>	request = new Request<>("private/fork_token", params);
		FutureResponse<Authorization>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public void	logout(logout	params)
	{
		Request<logout>	request = new Request<>("private/logout", params);

		messageWriter.post(request);
	}

	/*
	 * Account Management.
	 */
	public Future<ApiKey>	change_api_key_name(change_api_key_name	params)
	{
		Request<change_api_key_name>	request = new Request<>("private/change_api_key_name", params);
		FutureResponse<ApiKey>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<MarginModelChange>>	change_margin_model(change_margin_model	params)
	{
		Request<change_margin_model>	request = new Request<>("private/change_margin_model", params);
		FutureResponse<List<MarginModelChange>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<ApiKey>	change_scope_in_api_key(change_scope_in_api_key	params)
	{
		Request<change_scope_in_api_key>	request = new Request<>("private/change_scope_in_api_key", params);
		FutureResponse<ApiKey>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	change_subaccount_name(change_subaccount_name	params)
	{
		Request<change_subaccount_name>	request = new Request<>("private/change_subaccount_name", params);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<ApiKey>	create_api_key(create_api_key	params)
	{
		Request<create_api_key>	request = new Request<>("private/create_api_key", params);
		FutureResponse<ApiKey>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Account>	create_subaccount(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("private/create_subaccount", authorization);
		FutureResponse<Account>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<ApiKey>	disable_api_key(disable_api_key	params)
	{
		Request<disable_api_key>	request = new Request<>("private/disable_api_key", params);
		FutureResponse<ApiKey>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<ApiKey>	edit_api_key(edit_api_key	params)
	{
		Request<edit_api_key>	request = new Request<>("private/edit_api_key", params);
		FutureResponse<ApiKey>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<ApiKey>	enable_affiliate_program(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("private/enable_affiliate_program", authorization);
		FutureResponse<ApiKey>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<ApiKey>	enable_api_key(enable_api_key	params)
	{
		Request<enable_api_key>	request = new Request<>("private/enable_api_key", params);
		FutureResponse<ApiKey>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<AccessLog>	get_access_log(get_access_log	params)
	{
		Request<get_access_log>	request = new Request<>("private/get_access_log", params);
		FutureResponse<AccessLog>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<AccountSumaries>	get_account_summaries(get_account_summaries	params)
	{
		Request<get_account_summaries>	request = new Request<>("private/get_account_summaries", params);
		FutureResponse<AccountSumaries>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<AccountSummary>	get_account_summary(get_account_summary	params)
	{
		Request<get_account_summary>	request = new Request<>("private/get_account_summary", params);
		FutureResponse<AccountSummary>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<AffiliateProgram>	get_affiliate_program_info(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("private/get_affiliate_program_info", authorization);
		FutureResponse<AffiliateProgram>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	get_email_language(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("private/get_email_language", authorization);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<Announcement>>	get_new_announcements(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("private/get_new_announcements", authorization);
		FutureResponse<List<Announcement>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Position>	get_position(get_position	params)
	{
		Request<get_position>	request = new Request<>("private/get_position", params);
		FutureResponse<Position>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<Position>>	get_positions(get_positions	params)
	{
		Request<get_positions>	request = new Request<>("private/get_positions", params);
		FutureResponse<List<Position>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<Account>>	get_subaccounts(get_subaccounts	params)
	{
		Request<get_subaccounts>	request = new Request<>("private/get_subaccounts", params);
		FutureResponse<List<Account>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<AccountDetail>>	get_subaccounts_details(get_subaccounts_details	params)
	{
		Request<get_subaccounts_details>	request = new Request<>("private/get_subaccounts_details", params);
		FutureResponse<List<AccountDetail>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<TransactionLogs>	get_transaction_log(get_transaction_log	params)
	{
		Request<get_transaction_log>	request = new Request<>("private/get_transaction_log", params);
		FutureResponse<TransactionLogs>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<UserLock>>	get_user_locks(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("private/get_user_locks", authorization);
		FutureResponse<List<UserLock>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<ApiKey>>	list_api_keys(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("private/list_api_keys", authorization);
		FutureResponse<List<ApiKey>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<CustodyAccount>>	list_custody_accounts(list_custody_accounts	params)
	{
		Request<list_custody_accounts>	request = new Request<>("private/list_custody_accounts", params);
		FutureResponse<List<CustodyAccount>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Object>	pme_simulate(pme_simulate	params)
	{
		Request<pme_simulate>	request = new Request<>("private/pme/simulate", params);
		FutureResponse<Object>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	remove_api_key(remove_api_key	params)
	{
		Request<remove_api_key>	request = new Request<>("private/remove_api_key", params);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}
	
	public Future<String>	remove_subaccount(remove_subaccount	params)
	{
		Request<remove_subaccount>	request = new Request<>("private/remove_subaccount", params);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<ApiKey>	reset_api_key(reset_api_key	params)
	{
		Request<reset_api_key>	request = new Request<>("private/reset_api_key", params);
		FutureResponse<ApiKey>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	set_announcement_as_read(set_announcement_as_read	params)
	{
		Request<set_announcement_as_read>	request = new Request<>("private/set_announcement_as_read", params);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	set_disabled_trading_products(set_disabled_trading_products	params)
	{
		Request<set_disabled_trading_products>	request = new Request<>("private/set_disabled_trading_products", params);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	set_email_for_subaccount(set_email_for_subaccount	params)
	{
		Request<set_email_for_subaccount>	request = new Request<>("private/set_email_for_subaccount", params);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	set_email_language(set_email_language	params)
	{
		Request<set_email_language>	request = new Request<>("private/set_email_language", params);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	set_self_trading_config(set_self_trading_config	params)
	{
		Request<set_self_trading_config>	request = new Request<>("private/set_self_trading_config", params);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<AccountSummary>	simulate_portfolio(simulate_portfolio	params)
	{
		Request<simulate_portfolio>	request = new Request<>("private/simulate_portfolio", params);
		FutureResponse<AccountSummary>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	toggle_notifications_from_subaccount(toggle_notifications_from_subaccount	params)
	{
		Request<toggle_notifications_from_subaccount>	request = new Request<>("private/toggle_notifications_from_subaccount", params);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	toggle_subaccount_login(toggle_subaccount_login	params)
	{
		Request<toggle_subaccount_login>	request = new Request<>("private/toggle_subaccount_login", params);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<Announcement>>	get_announcements(get_announcements	params)
	{
		Request<get_announcements>	request = new Request<>("public/get_announcements", params);
		FutureResponse<List<Announcement>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	/*
	 * Combo Books.
	 */
	public Future<Combo>	create_combo(create_combo	params)
	{
		Request<create_combo>	request = new Request<>("private/create_combo", params);
		FutureResponse<Combo>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<LegPrices>	get_leg_prices(get_leg_prices	params)
	{
		Request<get_leg_prices>	request = new Request<>("private/get_leg_prices", params);
		FutureResponse<LegPrices>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Combo>	get_combo_details(get_combo_details	params)
	{
		Request<get_combo_details>	request = new Request<>("public/get_combo_details", params);
		FutureResponse<Combo>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<String>>	get_combo_ids(get_combo_ids	params)
	{
		Request<get_combo_ids>	request = new Request<>("public/get_combo_ids", params);
		FutureResponse<List<String>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<Combo>>	get_combos(get_combos	params)
	{
		Request<get_combos>	request = new Request<>("public/get_combos", params);
		FutureResponse<List<Combo>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	/*
	 * Market Data.
	 */
	public Future<AnnualPercentageRates>	get_apr_history(get_apr_history	params)
	{
		Request<get_apr_history>	request = new Request<>("public/get_apr_history", params);
		FutureResponse<AnnualPercentageRates>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<BookSummary>>	get_book_summary_by_currency(get_book_summary_by_currency	params)
	{
		Request<get_book_summary_by_currency>	request = new Request<>("public/get_book_summary_by_currency", params);
		FutureResponse<List<BookSummary>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<BookSummary>>	get_book_summary_by_instrument(get_book_summary_by_instrument	params)
	{
		Request<get_book_summary_by_instrument>	request = new Request<>("public/get_book_summary_by_instrument", params);
		FutureResponse<List<BookSummary>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<ContractSize>	get_contract_size(get_contract_size	params)
	{
		Request<get_contract_size>	request = new Request<>("public/get_contract_size", params);
		FutureResponse<ContractSize>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<CurrencyDetails>>	get_currencies(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("public/get_currencies", authorization);
		FutureResponse<List<CurrencyDetails>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<DeliveryPrices>	get_delivery_prices(get_delivery_prices	params)
	{
		Request<get_delivery_prices>	request = new Request<>("public/get_delivery_prices", params);
		FutureResponse<DeliveryPrices>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	/**
	 * Retrieves available expiration timestamps. The return type varies:
	 * <ul>
	 *   <li>{@code List<String>} when a specific {@code kind} is requested</li>
	 *   <li>{@code Map<String, List<String>>} when {@code kind = any}</li>
	 * </ul>
	 *
	 * @param <T>    the expected result type
	 * @param type   type reference for deserialization, e.g.
	 *               {@code new TypeReference<Response<Map<String, List<String>>>>() {}}
	 * @param params the request parameters
	 * @return a future with the expirations data
	 */
	public <T> Future<T>	get_expirations(TypeReference<Response<T>>	type, get_expirations	params)
	{
		Request<get_expirations>	request = new Request<>("public/get_expirations", params);
		FutureResponse<T>	futureResponse = new FutureResponse<>(request, type);

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<HistoricalFundingRate>>	get_funding_rate_history(get_funding_rate_history	params)
	{
		Request<get_funding_rate_history>	request = new Request<>("public/get_funding_rate_history", params);
		FutureResponse<List<HistoricalFundingRate>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<BigDecimal>	get_funding_rate_value(get_funding_rate_value	params)
	{
		Request<get_funding_rate_value>	request = new Request<>("public/get_funding_rate_value", params);
		FutureResponse<BigDecimal>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<HistoricalVolatility>>	get_historical_volatility(get_historical_volatility	params)
	{
		Request<get_historical_volatility>	request = new Request<>("public/get_historical_volatility", params);
		FutureResponse<List<HistoricalVolatility>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<IndexPrice>	get_index_price(get_index_price	params)
	{
		Request<get_index_price>	request = new Request<>("public/get_index_price", params);
		FutureResponse<IndexPrice>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<IndexPriceName>>	get_index_price_names(get_index_price_names	params)
	{
		Request<get_index_price_names>	request = new Request<>("public/get_index_price_names", params);
		FutureResponse<List<IndexPriceName>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Instrument>	get_instrument(get_instrument	params)
	{
		Request<get_instrument>	request = new Request<>("public/get_instrument", params);
		FutureResponse<Instrument>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<Instrument>>	get_instruments(get_instruments	params)
	{
		Request<get_instruments>	request = new Request<>("public/get_instruments", params);
		FutureResponse<List<Instrument>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Settlements>	get_last_settlements_by_currency(get_last_settlements_by_currency	params)
	{
		Request<get_last_settlements_by_currency>	request = new Request<>("public/get_last_settlements_by_currency", params);
		FutureResponse<Settlements>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Settlements>	get_last_settlements_by_instrument(get_last_settlements_by_instrument	params)
	{
		Request<get_last_settlements_by_instrument>	request = new Request<>("public/get_last_settlements_by_instrument", params);
		FutureResponse<Settlements>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<LastTrades>	get_last_trades_by_currency(get_last_trades_by_currency	params)
	{
		Request<get_last_trades_by_currency>	request = new Request<>("public/get_last_trades_by_currency", params);
		FutureResponse<LastTrades>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<LastTrades>	get_last_trades_by_currency_and_time(get_last_trades_by_currency_and_time	params)
	{
		Request<get_last_trades_by_currency_and_time>	request = new Request<>("public/get_last_trades_by_currency_and_time", params);
		FutureResponse<LastTrades>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<LastTrades>	get_last_trades_by_instrument(get_last_trades_by_instrument	params)
	{
		Request<get_last_trades_by_instrument>	request = new Request<>("public/get_last_trades_by_instrument", params);
		FutureResponse<LastTrades>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<LastTrades>	get_last_trades_by_instrument_and_time(get_last_trades_by_instrument_and_time	params)
	{
		Request<get_last_trades_by_instrument_and_time>	request = new Request<>("public/get_last_trades_by_instrument_and_time", params);
		FutureResponse<LastTrades>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<MarkPricePoint>>	get_mark_price_history(get_mark_price_history	params)
	{
		Request<get_mark_price_history>	request = new Request<>("public/get_mark_price_history", params);
		FutureResponse<List<MarkPricePoint>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<OrderBook>	get_order_book(get_order_book	params)
	{
		Request<get_order_book>	request = new Request<>("public/get_order_book", params);
		FutureResponse<OrderBook>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<OrderBook>	get_order_book_by_instrument_id(get_order_book_by_instrument_id	params)
	{
		Request<get_order_book_by_instrument_id>	request = new Request<>("public/get_order_book_by_instrument_id", params);
		FutureResponse<OrderBook>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<IndexPriceName>>	get_supported_index_names(get_supported_index_names	params)
	{
		Request<get_supported_index_names>	request = new Request<>("public/get_supported_index_names", params);
		FutureResponse<List<IndexPriceName>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<TradeVolume>>	get_trade_volumes(get_trade_volumes	params)
	{
		Request<get_trade_volumes>	request = new Request<>("public/get_trade_volumes", params);
		FutureResponse<List<TradeVolume>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<TradingViewChartData>	get_tradingview_chart_data(get_tradingview_chart_data	params)
	{
		Request<get_tradingview_chart_data>	request = new Request<>("public/get_tradingview_chart_data", params);
		FutureResponse<TradingViewChartData>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<VolatilityIndexData>	get_volatility_index_data(get_volatility_index_data	params)
	{
		Request<get_volatility_index_data>	request = new Request<>("public/get_volatility_index_data", params);
		FutureResponse<VolatilityIndexData>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<ticker>	ticker(get_ticker	params)
	{
		Request<get_ticker>	request = new Request<>("public/ticker", params);
		FutureResponse<ticker>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<FundingChartData>	get_funding_chart_data(get_funding_chart_data	params)
	{
		Request<get_funding_chart_data>	request = new Request<>("public/get_funding_chart_data", params);
		FutureResponse<FundingChartData>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<MarkPricePoint>>	get_index_chart_data(get_index_chart_data	params)
	{
		Request<get_index_chart_data>	request = new Request<>("public/get_index_chart_data", params);
		FutureResponse<List<MarkPricePoint>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	/*
	 * Session Management.
	 */
	public Future<String>	disable_cancel_on_disconnect(disable_cancel_on_disconnect	params)
	{
		Request<disable_cancel_on_disconnect>	request = new Request<>("private/disable_cancel_on_disconnect", params);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	enable_cancel_on_disconnect(enable_cancel_on_disconnect	params)
	{
		Request<enable_cancel_on_disconnect>	request = new Request<>("private/enable_cancel_on_disconnect", params);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<CancelOnDisconnect>	get_cancel_on_disconnect(get_cancel_on_disconnect	params)
	{
		Request<get_cancel_on_disconnect>	request = new Request<>("private/get_cancel_on_disconnect", params);
		FutureResponse<CancelOnDisconnect>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	disable_heartbeat(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("public/disable_heartbeat", authorization);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	set_heartbeat(set_heartbeat	params)
	{
		Request<set_heartbeat>	request = new Request<>("public/set_heartbeat", params);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	/*
	 * Subscription Management.
	 */
	public Future<List<String>>	private_subscribe(private_subscribe	params)
	{
		Request<private_subscribe>	request = new Request<>("private/subscribe", params);
		FutureResponse<List<String>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<String>>	private_unsubscribe(unsubscribe	params)
	{
		Request<unsubscribe>	request = new Request<>("private/unsubscribe", params);
		FutureResponse<List<String>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	private_unsubscribe_all(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("private/unsubscribe_all", authorization);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<String>>	public_subscribe(public_subscribe	params)
	{
		Request<public_subscribe>	request = new Request<>("public/subscribe", params);
		FutureResponse<List<String>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<String>>	public_unsubscribe(unsubscribe	params)
	{
		Request<unsubscribe>	request = new Request<>("public/unsubscribe", params);
		FutureResponse<List<String>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	public_unsubscribe_all(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("public/unsubscribe_all", authorization);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	/*
	 * Supporting.
	 */
	public Future<Long>	get_time(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("public/get_time", authorization);
		FutureResponse<Long>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Hello>	hello(hello	params)
	{
		Request<hello>	request = new Request<>("public/hello", params);
		FutureResponse<Hello>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Status>	status(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("public/status", authorization);
		FutureResponse<Status>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<TestResult>	test(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("public/test", authorization);
		FutureResponse<TestResult>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	/*
	 * Trading.
	 */
	public Future<OrderResponse>	buy(submit_order	params)
	{
		Request<submit_order>	request = new Request<>("private/buy", params);
		FutureResponse<OrderResponse>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Order>	cancel(cancel	params)
	{
		Request<cancel>	request = new Request<>("private/cancel", params);
		FutureResponse<Order>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Integer>	cancel_all(cancel_all	params)
	{
		Request<cancel_all>	request = new Request<>("private/cancel_all", params);
		FutureResponse<Integer>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Integer>	cancel_all_by_currency(cancel_all_by_currency	params)
	{
		Request<cancel_all_by_currency>	request = new Request<>("private/cancel_all_by_currency", params);
		FutureResponse<Integer>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Integer>	cancel_all_by_currency_pair(cancel_all_by_currency_pair	params)
	{
		Request<cancel_all_by_currency_pair>	request = new Request<>("private/cancel_all_by_currency_pair", params);
		FutureResponse<Integer>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Integer>	cancel_all_by_instrument(cancel_all_by_instrument	params)
	{
		Request<cancel_all_by_instrument>	request = new Request<>("private/cancel_all_by_instrument", params);
		FutureResponse<Integer>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Integer>	cancel_all_by_kind_or_type(cancel_all_by_kind_or_type	params)
	{
		Request<cancel_all_by_kind_or_type>	request = new Request<>("private/cancel_all_by_kind_or_type", params);
		FutureResponse<Integer>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Integer>	cancel_by_label(cancel_by_label	params)
	{
		Request<cancel_by_label>	request = new Request<>("private/cancel_by_label", params);
		FutureResponse<Integer>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<PositionClose>	close_position(close_position	params)
	{
		Request<close_position>	request = new Request<>("private/close_position", params);
		FutureResponse<PositionClose>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<OrderResponse>	edit(edit_order	params)
	{
		Request<edit_order>	request = new Request<>("private/edit", params);
		FutureResponse<OrderResponse>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<OrderResponse>	edit_by_label(edit_by_label	params)
	{
		Request<edit_by_label>	request = new Request<>("private/edit_by_label", params);
		FutureResponse<OrderResponse>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Margin>	get_margins(get_margins	params)
	{
		Request<get_margins>	request = new Request<>("private/get_margins", params);
		FutureResponse<Margin>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<MarketMakerProtectionConfig>	get_mmp_config(get_mmp_config	params)
	{
		Request<get_mmp_config>	request = new Request<>("private/get_mmp_config", params);
		FutureResponse<MarketMakerProtectionConfig>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<MarketMakerProtectionStatus>	get_mmp_status(get_mmp_status	params)
	{
		Request<get_mmp_status>	request = new Request<>("private/get_mmp_status", params);
		FutureResponse<MarketMakerProtectionStatus>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<Order>>	get_open_orders(get_open_orders	params)
	{
		Request<get_open_orders>	request = new Request<>("private/get_open_orders", params);
		FutureResponse<List<Order>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<Order>>	get_open_orders_by_currency(get_open_orders_by_currency	params)
	{
		Request<get_open_orders_by_currency>	request = new Request<>("private/get_open_orders_by_currency", params);
		FutureResponse<List<Order>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<Order>>	get_open_orders_by_instrument(get_open_orders_by_instrument	params)
	{
		Request<get_open_orders_by_instrument>	request = new Request<>("private/get_open_orders_by_instrument", params);
		FutureResponse<List<Order>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<Order>>	get_open_orders_by_label(get_open_orders_by_label	params)
	{
		Request<get_open_orders_by_label>	request = new Request<>("private/get_open_orders_by_label", params);
		FutureResponse<List<Order>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<Order>>	get_order_history_by_currency(get_order_history_by_currency	params)
	{
		Request<get_order_history_by_currency>	request = new Request<>("private/get_order_history_by_currency", params);
		FutureResponse<List<Order>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<Order>>	get_order_history_by_instrument(get_order_history_by_instrument	params)
	{
		Request<get_order_history_by_instrument>	request = new Request<>("private/get_order_history_by_instrument", params);
		FutureResponse<List<Order>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<OrderMargin>>	get_order_margin_by_ids(get_order_margin_by_ids	params)
	{
		Request<get_order_margin_by_ids>	request = new Request<>("private/get_order_margin_by_ids", params);
		FutureResponse<List<OrderMargin>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Order>	get_order_state(get_order_state	params)
	{
		Request<get_order_state>	request = new Request<>("private/get_order_state", params);
		FutureResponse<Order>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<Order>>	get_order_state_by_label(get_order_state_by_label	params)
	{
		Request<get_order_state_by_label>	request = new Request<>("private/get_order_state_by_label", params);
		FutureResponse<List<Order>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Settlements>	get_settlement_history_by_currency(get_settlement_history_by_currency	params)
	{
		Request<get_settlement_history_by_currency>	request = new Request<>("private/get_settlement_history_by_currency", params);
		FutureResponse<Settlements>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Settlements>	get_settlement_history_by_instrument(get_settlement_history_by_instrument	params)
	{
		Request<get_settlement_history_by_instrument>	request = new Request<>("private/get_settlement_history_by_instrument", params);
		FutureResponse<Settlements>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Orders>	get_trigger_order_history(get_trigger_order_history	params)
	{
		Request<get_trigger_order_history>	request = new Request<>("private/get_trigger_order_history", params);
		FutureResponse<Orders>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Trades>	get_user_trades_by_currency(get_user_trades_by_currency	params)
	{
		Request<get_user_trades_by_currency>	request = new Request<>("private/get_user_trades_by_currency", params);
		FutureResponse<Trades>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Trades>	get_user_trades_by_currency_and_time(get_user_trades_by_currency_and_time	params)
	{
		Request<get_user_trades_by_currency_and_time>	request = new Request<>("private/get_user_trades_by_currency_and_time", params);
		FutureResponse<Trades>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Trades>	get_user_trades_by_instrument(get_user_trades_by_instrument	params)
	{
		Request<get_user_trades_by_instrument>	request = new Request<>("private/get_user_trades_by_instrument", params);
		FutureResponse<Trades>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Trades>	get_user_trades_by_instrument_and_time(get_user_trades_by_instrument_and_time	params)
	{
		Request<get_user_trades_by_instrument_and_time>	request = new Request<>("private/get_user_trades_by_instrument_and_time", params);
		FutureResponse<Trades>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Trades>	get_user_trades_by_order(get_user_trades_by_order	params)
	{
		Request<get_user_trades_by_order>	request = new Request<>("private/get_user_trades_by_order", params);
		FutureResponse<Trades>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<PositionMove>>	move_positions(move_positions	params)
	{
		Request<move_positions>	request = new Request<>("private/move_positions", params);
		FutureResponse<List<PositionMove>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	reset_mmp(reset_mmp	params)
	{
		Request<reset_mmp>	request = new Request<>("private/reset_mmp", params);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<OrderResponse>	sell(submit_order	params)
	{
		Request<submit_order>	request = new Request<>("private/sell", params);
		FutureResponse<OrderResponse>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<MarketMakerProtectionConfig>>	set_mmp_config(set_mmp_config	params)
	{
		Request<set_mmp_config>	request = new Request<>("private/set_mmp_config", params);
		FutureResponse<List<MarketMakerProtectionConfig>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Integer>	cancel_quotes(cancel_quotes	params)
	{
		Request<cancel_quotes>	request = new Request<>("private/cancel_quotes", params);
		FutureResponse<Integer>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<MassQuote>	mass_quote(mass_quote	params)
	{
		Request<mass_quote>	request = new Request<>("private/mass_quote", params);
		FutureResponse<MassQuote>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	/*
	 * Wallet.
	 */
	public Future<Address>	add_to_address_book(add_to_address_book	params)
	{
		Request<add_to_address_book>	request = new Request<>("private/add_to_address_book", params);
		FutureResponse<Address>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Transfer>	cancel_transfer_by_id(cancel_transfer_by_id	params)
	{
		Request<cancel_transfer_by_id>	request = new Request<>("private/cancel_transfer_by_id", params);
		FutureResponse<Transfer>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Withdraw>	cancel_withdrawal(cancel_withdrawal	params)
	{
		Request<cancel_withdrawal>	request = new Request<>("private/cancel_withdrawal", params);
		FutureResponse<Withdraw>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<DepositAddress>	create_deposit_address(create_deposit_address	params)
	{
		Request<create_deposit_address>	request = new Request<>("private/create_deposit_address", params);
		FutureResponse<DepositAddress>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	delete_address_beneficiary(delete_address_beneficiary	params)
	{
		Request<delete_address_beneficiary>	request = new Request<>("private/delete_address_beneficiary", params);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Beneficiary>	get_address_beneficiary(get_address_beneficiary	params)
	{
		Request<get_address_beneficiary>	request = new Request<>("private/get_address_beneficiary", params);
		FutureResponse<Beneficiary>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<Address>>	get_address_book(get_address_book	params)
	{
		Request<get_address_book>	request = new Request<>("private/get_address_book", params);
		FutureResponse<List<Address>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<DepositAddress>	get_current_deposit_address(get_current_deposit_address	params)
	{
		Request<get_current_deposit_address>	request = new Request<>("private/get_current_deposit_address", params);
		FutureResponse<DepositAddress>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Deposits>	get_deposits(get_deposits	params)
	{
		Request<get_deposits>	request = new Request<>("private/get_deposits", params);
		FutureResponse<Deposits>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<RewardEligibility>	get_reward_eligibility(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("private/get_reward_eligibility", authorization);
		FutureResponse<RewardEligibility>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Transfers>	get_transfers(get_transfers	params)
	{
		Request<get_transfers>	request = new Request<>("private/get_transfers", params);
		FutureResponse<Transfers>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Withdraws>	get_withdraws(get_withdraws	params)
	{
		Request<get_withdraws>	request = new Request<>("private/get_withdraws", params);
		FutureResponse<Withdraws>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<Beneficiary>>	list_address_beneficiaries(list_address_beneficiaries	params)
	{
		Request<list_address_beneficiaries>	request = new Request<>("private/list_address_beneficiaries", params);
		FutureResponse<List<Beneficiary>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	remove_from_address_book(remove_from_address_book	params)
	{
		Request<remove_from_address_book>	request = new Request<>("private/remove_from_address_book", params);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Beneficiary>	save_address_beneficiary(save_address_beneficiary	params)
	{
		Request<save_address_beneficiary>	request = new Request<>("private/save_address_beneficiary", params);
		FutureResponse<Beneficiary>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Deposit>	set_clearance_originator(set_clearance_originator	params)
	{
		Request<set_clearance_originator>	request = new Request<>("private/set_clearance_originator", params);
		FutureResponse<Deposit>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Transfer>	submit_transfer_between_subaccounts(submit_transfer_between_subaccounts	params)
	{
		Request<submit_transfer_between_subaccounts>	request = new Request<>("private/submit_transfer_between_subaccounts", params);
		FutureResponse<Transfer>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Transfer>	submit_transfer_to_subaccount(submit_transfer_to_subaccount	params)
	{
		Request<submit_transfer_to_subaccount>	request = new Request<>("private/submit_transfer_to_subaccount", params);
		FutureResponse<Transfer>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Transfer>	submit_transfer_to_user(submit_transfer_to_user	params)
	{
		Request<submit_transfer_to_user>	request = new Request<>("private/submit_transfer_to_user", params);
		FutureResponse<Transfer>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<String>	update_in_address_book(update_in_address_book	params)
	{
		Request<update_in_address_book>	request = new Request<>("private/update_in_address_book", params);
		FutureResponse<String>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Withdraw>	withdraw(withdraw	params)
	{
		Request<withdraw>	request = new Request<>("private/withdraw", params);
		FutureResponse<Withdraw>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	/*
	 * Block RFQ.
	 */
	public Future<BlockRfq>	create_block_rfq(create_block_rfq	params)
	{
		Request<create_block_rfq>	request = new Request<>("private/create_block_rfq", params);
		FutureResponse<BlockRfq>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Void>	cancel_block_rfq(cancel_block_rfq	params)
	{
		Request<cancel_block_rfq>	request = new Request<>("private/cancel_block_rfq", params);
		FutureResponse<Void>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<BlockRfq>>	get_block_rfqs(get_block_rfqs	params)
	{
		Request<get_block_rfqs>	request = new Request<>("private/get_block_rfqs", params);
		FutureResponse<List<BlockRfq>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<String>>	get_block_rfq_makers(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("private/get_block_rfq_makers", authorization);
		FutureResponse<List<String>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<BlockRfq>	add_block_rfq_quote(add_block_rfq_quote	params)
	{
		Request<add_block_rfq_quote>	request = new Request<>("private/add_block_rfq_quote", params);
		FutureResponse<BlockRfq>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<BlockRfq>	edit_block_rfq_quote(edit_block_rfq_quote	params)
	{
		Request<edit_block_rfq_quote>	request = new Request<>("private/edit_block_rfq_quote", params);
		FutureResponse<BlockRfq>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Void>	cancel_block_rfq_quote(cancel_block_rfq_quote	params)
	{
		Request<cancel_block_rfq_quote>	request = new Request<>("private/cancel_block_rfq_quote", params);
		FutureResponse<Void>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Void>	cancel_all_block_rfq_quotes(cancel_all_block_rfq_quotes	params)
	{
		Request<cancel_all_block_rfq_quotes>	request = new Request<>("private/cancel_all_block_rfq_quotes", params);
		FutureResponse<Void>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<BlockRfq.Quote>>	get_block_rfq_quotes(get_block_rfq_quotes	params)
	{
		Request<get_block_rfq_quotes>	request = new Request<>("private/get_block_rfq_quotes", params);
		FutureResponse<List<BlockRfq.Quote>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Void>	accept_block_rfq(accept_block_rfq	params)
	{
		Request<accept_block_rfq>	request = new Request<>("private/accept_block_rfq", params);
		FutureResponse<Void>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Void>	cancel_block_rfq_trigger(cancel_block_rfq_trigger	params)
	{
		Request<cancel_block_rfq_trigger>	request = new Request<>("private/cancel_block_rfq_trigger", params);
		FutureResponse<Void>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<BlockRfqUserInfo>	get_block_rfq_user_info(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("private/get_block_rfq_user_info", authorization);
		FutureResponse<BlockRfqUserInfo>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<BlockRfqTrades>	get_block_rfq_trades(get_block_rfq_trades	params)
	{
		Request<get_block_rfq_trades>	request = new Request<>("public/get_block_rfq_trades", params);
		FutureResponse<BlockRfqTrades>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	/*
	 * Block Trade.
	 */
	public Future<BlockTradeSignature>	verify_block_trade(verify_block_trade	params)
	{
		Request<verify_block_trade>	request = new Request<>("private/verify_block_trade", params);
		FutureResponse<BlockTradeSignature>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<BlockTrade>	execute_block_trade(execute_block_trade	params)
	{
		Request<execute_block_trade>	request = new Request<>("private/execute_block_trade", params);
		FutureResponse<BlockTrade>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Void>	invalidate_block_trade_signature(invalidate_block_trade_signature	params)
	{
		Request<invalidate_block_trade_signature>	request = new Request<>("private/invalidate_block_trade_signature", params);
		FutureResponse<Void>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<BlockTrade>	get_block_trade(get_block_trade	params)
	{
		Request<get_block_trade>	request = new Request<>("private/get_block_trade", params);
		FutureResponse<BlockTrade>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<BlockTrade>>	get_block_trades(get_block_trades	params)
	{
		Request<get_block_trades>	request = new Request<>("private/get_block_trades", params);
		FutureResponse<List<BlockTrade>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<BlockTradeRequest>>	get_block_trade_requests(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("private/get_block_trade_requests", authorization);
		FutureResponse<List<BlockTradeRequest>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Void>	approve_block_trade(approve_block_trade	params)
	{
		Request<approve_block_trade>	request = new Request<>("private/approve_block_trade", params);
		FutureResponse<Void>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Void>	reject_block_trade(reject_block_trade	params)
	{
		Request<reject_block_trade>	request = new Request<>("private/reject_block_trade", params);
		FutureResponse<Void>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<Void>	simulate_block_trade(simulate_block_trade	params)
	{
		Request<simulate_block_trade>	request = new Request<>("private/simulate_block_trade", params);
		FutureResponse<Void>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<BrokerClient>>	get_broker_clients(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("private/get_broker_clients", authorization);
		FutureResponse<List<BrokerClient>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<BlockTradeRequest>>	get_broker_trade_requests(Authorization	authorization)
	{
		Request<Authorization>	request = new Request<>("private/get_broker_trade_requests", authorization);
		FutureResponse<List<BlockTradeRequest>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	public Future<List<BlockTrade>>	get_broker_trades(get_broker_trades	params)
	{
		Request<get_broker_trades>	request = new Request<>("private/get_broker_trades", params);
		FutureResponse<List<BlockTrade>>	futureResponse = new FutureResponse<>(request, new TypeReference<>() {});

		messageReader.put(futureResponse);
		messageWriter.post(request);

		return futureResponse;
	}

	private MessageReader	messageReader;
	private MessageWriter	messageWriter;
}
