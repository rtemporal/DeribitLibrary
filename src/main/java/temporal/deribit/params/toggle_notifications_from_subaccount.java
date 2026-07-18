package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record toggle_notifications_from_subaccount
(
	@JsonUnwrapped
	Authorization	authorization,
	int	sid,
	boolean	state
)
{
}
