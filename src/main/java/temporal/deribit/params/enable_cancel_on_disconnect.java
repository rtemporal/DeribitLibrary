package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record enable_cancel_on_disconnect
(
	@JsonUnwrapped
	Authorization	authorization,
	Scope	scope
)
{
	public enum Scope
	{
		connection,
		account
	}
}
