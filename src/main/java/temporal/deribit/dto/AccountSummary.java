package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record AccountSummary
(
	BigDecimal	options_pl,
	BigDecimal	projected_delta_total,
	Object	options_theta_map,
	Boolean	has_non_block_chain_equity,
	BigDecimal	total_margin_balance_usd,
	Limits	limits,
	String	type,
	BigDecimal	total_delta_total_usd,
	BigDecimal	available_withdrawal_funds,
	Object	estimated_liquidation_ratio_map,
	BigDecimal	options_session_rpl,
	BigDecimal	futures_session_rpl,
	BigDecimal	total_pl,
	BigDecimal	spot_reserve,
	Fee[]	fees,
	BigDecimal	additional_reserve,
	BigDecimal	options_session_upl,
	boolean	cross_collateral_enabled,
	Object	delta_total_map,
	Integer	id,
	BigDecimal	options_value,
	Long	creation_timestamp,
	String	email,
	Object	options_vega_map,
	BigDecimal	maintenance_margin,
	Boolean	mmp_enabled,
	BigDecimal	futures_session_upl,
	boolean	portfolio_margining_enabled,
	BigDecimal	futures_pl,
	Object	options_gamma_map,
	Currency	currency,
	BigDecimal	options_delta,
	BigDecimal	initial_margin,
	BigDecimal	projected_maintenance_margin,
	BigDecimal	available_funds,
	String	referrer_id,
	Boolean	login_enabled,
	BigDecimal	equity,
	String	margin_model,
	BigDecimal	balance,
	BigDecimal	session_upl,
	BigDecimal	margin_balance,
	Boolean	security_keys_enabled,
	String	deposit_address,
	BigDecimal	options_theta,
	String	self_trading_extended_to_subaccounts,
	Boolean	interuser_transfers_enabled,
	BigDecimal	total_initial_margin_usd,
	BigDecimal	estimated_liquidation_ratio,
	BigDecimal	session_rpl,
	BigDecimal	fee_balance,
	BigDecimal	total_maintenance_margin_usd,
	BigDecimal	options_vega,
	BigDecimal	projected_initial_margin,
	String	self_trading_reject_mode,
	String	system_name,
	BigDecimal	options_gamma,
	String	username,
	BigDecimal	total_equity_usd,
	BigDecimal	delta_total,
	
	/*
	 * Fields not documented.
	 */
	ChangeMarginModelApiLimit	change_margin_model_api_limit,
	BigDecimal	locked_balance,
	Boolean	mandatory_tfa,
	BigDecimal	projected_close_out_margin,
	Boolean	disable_kyc_verification,
	Boolean	receive_notifications,
	Object	trading_products_details,
	Boolean	block_rfq_self_match_prevention,
	BigDecimal	close_out_margin,
	Boolean	direct_access_enabled
)
implements Serializable {
	public record Limits
	(
		boolean	limits_per_currency,
		MatchingEngine	matching_engine,
		RateLimit	non_matching_engine
	)
implements Serializable {	
	}

	public record MatchingEngine
	(
		RateLimit	block_rfq_maker,
		RateLimit	cancel_all,
		RateLimit	guaranteed_mass_quotes,
		RateLimit	maximum_mass_quotes,
		RateLimit	maximum_quotes,
		RateLimit	spot,
		Trading	trading
	)
implements Serializable {
	}

	public record Trading
	(
		RateLimit	total
	)
implements Serializable {
	}

	public record RateLimit
	(
		short	rate,
		short	burst
	)
implements Serializable {
	}

	public record Fee
	(
		IndexName	index_name,
		String	kind,
		Object	value
	)
implements Serializable {	
	}

	public record ChangeMarginModelApiLimit
	(
		int	timeframe,
		short	rate
	)
implements Serializable {
	}
}
