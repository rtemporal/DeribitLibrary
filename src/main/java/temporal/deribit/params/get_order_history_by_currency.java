package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;
import temporal.deribit.dto.Kind;

public record get_order_history_by_currency
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	Kind	kind,
	Short	count,
	Integer	offset,
	Boolean	include_old,
	Boolean	include_unfilled,
	Boolean	with_continuation,
	String	continuation,
	Boolean	historical
)
{
}
