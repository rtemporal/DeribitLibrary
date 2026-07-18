package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record get_block_rfqs
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	String	state,
	Integer	page_size,
	Integer	offset,
	String	taker_side
)
{
}
