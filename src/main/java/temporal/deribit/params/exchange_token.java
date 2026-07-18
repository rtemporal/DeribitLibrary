package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record exchange_token
(
	@JsonUnwrapped
	Authorization	authorization,
	String	refresh_token,
	int	subject_id,
	Scope	scope
)
{
	public enum Scope
	{
		session
	}
}
