package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record get_trigger_order_history
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	String	instrument_name,
	Short	count,
	String	continuation
)
{
}
