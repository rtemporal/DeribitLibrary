package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record change_api_key_name
(
	@JsonUnwrapped
	Authorization	authorization,
	int	id,
	String	name		
)
{
}
