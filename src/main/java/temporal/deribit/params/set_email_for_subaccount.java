package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record set_email_for_subaccount
(
	@JsonUnwrapped
	Authorization	authorization,
	int	sid,
	String	email
)
{
}
