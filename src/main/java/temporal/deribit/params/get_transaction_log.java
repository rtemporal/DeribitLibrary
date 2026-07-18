package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record get_transaction_log
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	curreny,
	long	start_timestamp,
	long	end_timestamp,
	String	query,
	Short	count,
	Integer	subaccount_id,
	Integer	continuation
)
{
}
