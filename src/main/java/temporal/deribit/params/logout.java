package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record logout
(
	@JsonUnwrapped
	Authorization	authorization,
	Boolean	invalidate_token
)
{
}
