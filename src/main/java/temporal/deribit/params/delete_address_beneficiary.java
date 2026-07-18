package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record delete_address_beneficiary
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	String	address,
	String	tag
)
{
}
