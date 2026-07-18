package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record cancel_all
(
	@JsonUnwrapped
	Authorization	authorization,
	Boolean	detailed,
	Boolean	freeze_quotes
)
{
}
