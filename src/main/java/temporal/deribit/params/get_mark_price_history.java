package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_mark_price_history
(
	@JsonUnwrapped
	Authorization	authorization,
	String	instrument_name,
	Long	start_timestamp,
	Long	end_timestamp,
	Short	count,
	Sorting	sorting
)
{
}
