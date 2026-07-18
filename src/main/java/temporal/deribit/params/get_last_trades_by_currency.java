package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;
import temporal.deribit.dto.Kind;

public record get_last_trades_by_currency
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	Kind	kind,
	String	start_id,
	String	end_id,
	Long	start_timestamp,
	Long	end_timestamp,
	Short	count,
	Sorting	sorting
)
{
}
