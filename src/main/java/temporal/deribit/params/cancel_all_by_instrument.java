package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record cancel_all_by_instrument
(
	@JsonUnwrapped
	Authorization	authorization,
	String	instrument_name,
	Type	type,
	Boolean	detailed,
	Boolean	include_combos,
	Boolean	freeze_quotes
)
{
	public enum Type
	{
		all,
		limit,
		trigger_all,
		stop,
		take,
		trailing_stop
	}
}
