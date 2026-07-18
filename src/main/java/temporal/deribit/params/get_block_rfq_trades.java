package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_block_rfq_trades
(
	@JsonUnwrapped
	Authorization	authorization,
	String	currency,
	String	continuation,
	Integer	count
)
{
}
