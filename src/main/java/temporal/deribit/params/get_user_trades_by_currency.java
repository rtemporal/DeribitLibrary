package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;
import temporal.deribit.dto.Kind;

public record get_user_trades_by_currency
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	Kind	kind,
	String	start_id,
	String	end_id,
	Short	count,
	/**
	 * The start timestamp is inclusive.
	 */
	Long	start_timestamp,
	
	/**
	 * The end timestamp is inclusive.
	 */
	Long	end_timestamp,
	Boolean	historical,
	Integer	subaccount_id
)
{
}
