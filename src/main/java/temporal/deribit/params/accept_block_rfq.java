package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record accept_block_rfq
(
	@JsonUnwrapped
	Authorization	authorization,
	Integer	block_rfq_id,
	Integer	quote_id
)
{
}
