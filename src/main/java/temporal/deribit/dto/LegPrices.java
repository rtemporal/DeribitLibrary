package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record LegPrices
(
	LegPrice[]	legs,
	BigDecimal	amount
)
implements Serializable {
	public record LegPrice
	(
		Integer	ratio,
		String	instrument_name,
		Direction	direction,
		BigDecimal	price
	)
implements Serializable {
	}
}
