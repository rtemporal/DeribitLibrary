package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record get_account_summary
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	Integer	subaccount_id,
	Boolean	extended
)
{
}
