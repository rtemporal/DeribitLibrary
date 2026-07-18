package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_settlement_history_by_instrument
(
	@JsonUnwrapped
	Authorization	authorization,
	String	instrument_name,
	Type	type,
	Short	count,
	String	continuation,
	
	/**
	 * The start is the greatest timestamp inclusive.
	 */
	Long	search_start_timestamp
)
{
	public enum Type
	{
		settlement,
		delivery,
		bankruptcy
	}
}
