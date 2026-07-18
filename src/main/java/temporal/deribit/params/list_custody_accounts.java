package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record list_custody_accounts
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency
)
{
}
