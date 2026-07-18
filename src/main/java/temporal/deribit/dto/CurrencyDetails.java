package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record CurrencyDetails
(
	BigDecimal	apr,
	String	coin_type,
	Currency	currency,
	String	currency_long,
	Integer	fee_precision,
	boolean	in_cross_collateral_pool,
	int	min_confirmations,
	BigDecimal	min_withdrawal_fee,
	BigDecimal	withdrawal_fee,
	WithdrawalPriority[]	withdrawal_priorities,

	/**
	 * Fields not documented.
	 */
	BigDecimal	network_fee,
	Currency	network_currency
)
implements Serializable {
	public record WithdrawalPriority
	(
		String	name,
		float	value
	)
implements Serializable {
	}
}
