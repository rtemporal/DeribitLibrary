package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;
import temporal.deribit.dto.Kind;

public record get_user_trades_by_currency_and_time
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	Kind	kind,
	/**
	 * The start timestamp is inclusive.
	 */
	Long	start_timestamp,
	
	/**
	 * The end timestamp is inclusive.
	 */
	Long	end_timestamp,
	Short	count,
	Sorting	sorting,
	Boolean	historical
)
{
}
