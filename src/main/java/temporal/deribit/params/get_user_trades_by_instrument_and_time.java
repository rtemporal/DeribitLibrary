package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_user_trades_by_instrument_and_time
(
	@JsonUnwrapped
	Authorization	authorization,
	String	instrument_name,
	/**
	 * The start timestamp is inclusive.
	 */
	Long	start_timestamp,
	
	/**
	 * The end timestamp is inclusive.
	 */
	Long	end_timestamp,
	Short	count,
	Sorting	sorting,
	Boolean	historical
)
{
}
