package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record change_subaccount_name
(
	@JsonUnwrapped
	Authorization	authorization,
	int	sid,
	String	name
)
{
}
