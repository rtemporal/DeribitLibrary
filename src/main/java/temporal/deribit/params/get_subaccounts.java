package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_subaccounts
(
	@JsonUnwrapped
	Authorization	authorization,
	Boolean	with_portfolio
)
{
}
