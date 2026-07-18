package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record approve_block_trade
(
	@JsonUnwrapped
	Authorization	authorization,
	String	nonce,
	Long	timestamp,
	String	role
)
{
}
