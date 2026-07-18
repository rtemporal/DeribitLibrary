package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record cancel_all_block_rfq_quotes
(
	@JsonUnwrapped
	Authorization	authorization,
	Integer	block_rfq_id
)
{
}
