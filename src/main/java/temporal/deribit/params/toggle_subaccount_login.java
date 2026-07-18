package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record toggle_subaccount_login
(
	@JsonUnwrapped
	Authorization	authorization,
	int	sid,
	State	state
)
{
	public enum State
	{
		enable,
		disable
	}
}
