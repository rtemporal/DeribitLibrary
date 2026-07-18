package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_account_summaries
(
	@JsonUnwrapped
	Authorization	authorization,
	Integer	subaccount_id,
	Boolean	extended
)
{
}
