package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_order_history_by_instrument
(
	@JsonUnwrapped
	Authorization	authorization,
	String	instrument_name,
	Short	count,
	Integer	offset,
	Boolean	include_old,
	Boolean	include_unfilled,
	Boolean	with_continuation,
	String	continuation,
	Boolean	historical
)
{
	public enum Type
	{
		all,
		limit,
		trigger_all,
		stop_all,
		stop_limit,
		stop_market,
		take_all,
		take_limit,
		take_market,
		trailing_all,
		trailing_stop
	}
}
