package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record remove_from_address_book
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	Type	type,
	String	address
)
{
	public enum Type
	{
		transfer,
		withdrawal,
		deposit_source
	}
}
