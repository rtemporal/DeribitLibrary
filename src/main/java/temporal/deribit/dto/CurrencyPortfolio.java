package temporal.deribit.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public record CurrencyPortfolio
(
	BigDecimal	margin_balance,
	String	currency,
	BigDecimal	maintenance_margin,
	BigDecimal	initial_margin,
	BigDecimal	equity,
	BigDecimal	balance,
	BigDecimal	available_withdrawal_funds,
	BigDecimal	available_funds,
	BigDecimal	additional_reserve,
	BigDecimal	spot_reserve
)
implements Serializable
{
}
