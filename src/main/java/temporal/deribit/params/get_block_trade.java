package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_block_trade
(
	@JsonUnwrapped
	Authorization	authorization,
	String	block_trade_id
)
{
}
