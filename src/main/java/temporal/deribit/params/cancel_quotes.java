package temporal.deribit.params;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;
import temporal.deribit.dto.Kind;

public record cancel_quotes
(
	@JsonUnwrapped
	Authorization	authorization,
	String	cancel_type,
	Currency	currency,
	String	currency_pair,
	String	instrument_name,
	Kind	kind,
	BigDecimal	min_delta,
	BigDecimal	max_delta,
	String	quote_set_id,
	Boolean	detailed,
	Boolean	freeze_quotes
)
{
}
