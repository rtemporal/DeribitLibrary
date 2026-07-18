package temporal.deribit.params;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Direction;

public record create_block_rfq
(
	@JsonUnwrapped
	Authorization	authorization,
	List<Leg>	legs,
	List<TradeAllocation>	trade_allocations,
	Hedge	hedge,
	String	label,
	List<String>	makers,
	Boolean	disclosed
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

	public record TradeAllocation
	(
		Integer	user_id,
		ClientInfo	client_info,
		BigDecimal	amount
	)
	{
		public record ClientInfo
		(
			Integer	client_id,
			Integer	client_link_id
		)
		{
		}
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
