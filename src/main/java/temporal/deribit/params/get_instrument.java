package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_instrument
(
	@JsonUnwrapped
	Authorization	authorization,
	String	instrument_name
)
{
}
