package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record simulate_portfolio
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	boolean	add_positions,
	String	simulated_positions
)
{
}
