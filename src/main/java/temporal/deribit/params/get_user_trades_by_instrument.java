package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_user_trades_by_instrument
(
	@JsonUnwrapped
	Authorization	authorization,
	String	instrument_name,
	String	start_seq,
	String	end_seq,
	Short	count,
	/**
	 * The start timestamp is inclusive.
	 */
	Long	start_timestamp,
	
	/**
	 * The end timestamp is inclusive.
	 */
	Long	end_timestamp,
	Boolean	historical,
	Sorting	sorting
)
{
}
