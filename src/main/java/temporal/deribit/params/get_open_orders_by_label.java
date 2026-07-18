package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record get_open_orders_by_label
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	String	label
)
{
}
