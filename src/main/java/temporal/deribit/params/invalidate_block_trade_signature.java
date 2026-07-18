package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record invalidate_block_trade_signature
(
	@JsonUnwrapped
	Authorization	authorization,
	String	nonce,
	Long	timestamp
)
{
}
