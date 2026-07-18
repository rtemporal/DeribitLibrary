package temporal.deribit.params;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Direction;

public record create_combo
(
	@JsonUnwrapped
	Authorization	authorization,
	Leg[]	trades
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
