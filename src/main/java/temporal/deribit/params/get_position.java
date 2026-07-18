package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_position
(
	@JsonUnwrapped
	Authorization	authorization,
	String	instrument_name
)
{
}
