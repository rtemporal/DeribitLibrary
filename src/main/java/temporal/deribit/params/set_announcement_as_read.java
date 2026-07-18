package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record set_announcement_as_read
(
	@JsonUnwrapped
	Authorization	authorization,
	int	announcement_id
)
{
}
