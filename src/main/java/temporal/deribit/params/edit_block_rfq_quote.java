package temporal.deribit.params;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record edit_block_rfq_quote
(
	@JsonUnwrapped
	Authorization	authorization,
	Integer	block_rfq_id,
	BigDecimal	price,
	BigDecimal	amount,
	String	execution_instruction,
	Long	expires_at
)
{
}
