package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record remove_subaccount
(
	@JsonUnwrapped
	Authorization	authorization,
	int	id
)
{
}
