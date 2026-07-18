package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record reject_block_trade
(
	@JsonUnwrapped
	Authorization	authorization,
	String	nonce,
	Long	timestamp,
	String	role
)
{
}
