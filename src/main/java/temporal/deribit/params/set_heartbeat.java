package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record set_heartbeat
(
	@JsonUnwrapped
	Authorization	authorization,
	int	interval
)
{
}
