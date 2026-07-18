package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record get_settlement_history_by_currency
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	Type	type,
	Short	count,
	String	continuation,
	
	/**
	 * The start is the greatest timestamp inclusive.
	 */
	Long	search_start_timestamp
)
{
	public enum Type
	{
		settlement,
		delivery,
		bankruptcy
	}
}
