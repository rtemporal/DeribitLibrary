package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record reset_api_key
(
	@JsonUnwrapped
	Authorization	authorization,
	int	id
)
{
}
