package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record cancel_by_label
(
	@JsonUnwrapped
	Authorization	authorization,
	String	label,
	Currency	currency
)
{
}
