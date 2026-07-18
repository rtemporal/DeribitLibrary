package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record get_apr_history
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	Short	limit,
	Long	before
)
{
}
