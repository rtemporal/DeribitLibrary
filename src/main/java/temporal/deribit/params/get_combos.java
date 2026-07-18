package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record get_combos
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency
)
{
}
