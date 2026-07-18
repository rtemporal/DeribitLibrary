package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Settlement.Type;

public record get_last_settlements_by_instrument
(
	@JsonUnwrapped
	Authorization	authorization,
	String	instrument_name,
	Type	type,
	Short	count,
	String	continuation,
	Long	search_start_timestamp
)
{
}
