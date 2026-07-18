package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;
import temporal.deribit.dto.Kind;

public record get_book_summary_by_currency
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	Kind	kind
)
{
}
