package temporal.deribit.params;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Direction;

public record simulate_block_trade
(
	@JsonUnwrapped
	Authorization	authorization,
	List<Leg>	legs,
	Hedge	hedge
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

	public record Hedge
	(
		String	instrument_name,
		Direction	direction,
		BigDecimal	price,
		BigDecimal	amount
	)
	{
	}
}
