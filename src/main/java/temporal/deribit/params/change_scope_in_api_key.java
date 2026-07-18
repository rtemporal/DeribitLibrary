package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record change_scope_in_api_key
(
	@JsonUnwrapped
	Authorization	authorization,
	int	id,
	String[]	max_scope
)
{
}
