package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record hello
(
	@JsonUnwrapped
	Authorization	authorization,
	String	client_name,
	String	client_version
)
{
}
