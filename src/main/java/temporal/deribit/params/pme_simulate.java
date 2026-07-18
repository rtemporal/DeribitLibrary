package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record pme_simulate
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	Boolean	add_positions,
	String	simulated_positions
)
{
}
