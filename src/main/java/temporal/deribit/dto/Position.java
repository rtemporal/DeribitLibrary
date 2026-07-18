package temporal.deribit.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public record Position
(
	BigDecimal	average_price,
	BigDecimal	average_price_usd,
	Float	delta,
	Direction	direction,
	BigDecimal	estimated_liquidation_price,
	BigDecimal	floating_profit_loss,
	BigDecimal	floating_profit_loss_usd,
	Float	gamma,
	BigDecimal	index_price,
	BigDecimal	initial_margin,
	String	instrument_name,
	BigDecimal	interest_value,
	Kind	kind,
	Integer	leverage,
	BigDecimal	maintenance_margin,
	BigDecimal	mark_price,
	BigDecimal	open_orders_margin,
	BigDecimal	realized_funding,
	BigDecimal	realized_profit_loss,
	BigDecimal	settlement_price,
	BigDecimal	size,
	BigDecimal	size_currency,
	Float	theta,
	BigDecimal	total_profit_loss,
	Float	vega
)

implements Serializable {
}
