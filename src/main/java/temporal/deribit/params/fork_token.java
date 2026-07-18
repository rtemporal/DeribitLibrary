package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record fork_token
(
	@JsonUnwrapped
	Authorization	authorization,
	String	refresh_token,
	String	session_name
)
{
}
