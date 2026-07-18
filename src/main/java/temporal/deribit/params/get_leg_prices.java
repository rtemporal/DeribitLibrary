package temporal.deribit.params;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Direction;

public record get_leg_prices
(
	@JsonUnwrapped
	Authorization	authorization,
	Leg[]	legs,
	BigDecimal	price
)
{
	public record Leg
	(
		String	instrument_name,
		BigDecimal	amount,
		Direction	direction
	)
	{
	}
}
