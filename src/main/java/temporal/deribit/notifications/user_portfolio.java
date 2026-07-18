package temporal.deribit.notifications;

import java.io.Serializable;
import java.math.BigDecimal;

import temporal.deribit.dto.Currency;

public record user_portfolio
(
	BigDecimal	options_pl,
	BigDecimal	projected_delta_total,
	Object	options_theta_map,
	BigDecimal	total_margin_balance_usd,
	BigDecimal	total_delta_total_usd,
	BigDecimal	available_withdrawal_funds,
	Object		estimated_liquidation_ratio_map,
	BigDecimal	options_session_rpl,
	BigDecimal	futures_session_rpl,
	BigDecimal	total_pl,
	BigDecimal	additional_reserve,
	BigDecimal	options_session_upl,
	Boolean	cross_collateral_enabled,
	Object	delta_total_map,
	BigDecimal	options_value,
	Object	options_vega_map,
	BigDecimal	maintenance_margin,
	BigDecimal	futures_session_upl,
	Boolean	portfolio_margining_enabled,
	BigDecimal	futures_pl,
	Object	options_gamma_map,
	Currency	currency,
	BigDecimal	options_delta,
	BigDecimal	initial_margin,
	BigDecimal	projected_maintenance_margin,
	BigDecimal	available_funds,
	BigDecimal	equity,
	String	margin_model,
	BigDecimal	balance,
	BigDecimal	session_upl,
	BigDecimal	margin_balance,
	BigDecimal	options_theta,
	BigDecimal	total_initial_margin_usd,
	BigDecimal	estimated_liquidation_ratio,
	BigDecimal	session_rpl,
	BigDecimal	fee_balance,
	BigDecimal	total_maintenance_margin_usd,
	BigDecimal	options_vega,
	BigDecimal	projected_initial_margin,
	BigDecimal	options_gamma,
	BigDecimal	total_equity_usd,
	BigDecimal	delta_total,
	
	/**
	 * Fields not documented.
	 */
	BigDecimal	spot_reserve,
	BigDecimal	locked_balance
)

implements Serializable {
}
