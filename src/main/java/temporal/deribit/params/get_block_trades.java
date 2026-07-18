package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record get_block_trades
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	Integer	count,
	String	start_id,
	String	end_id,
	Integer	block_rfq_id,
	String	broker_code
)
{
}
