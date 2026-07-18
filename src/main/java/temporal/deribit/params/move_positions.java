package temporal.deribit.params;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record move_positions
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	Integer	source_uid,
	Integer	target_uid,
	Move	trades
)
{
	public record Move
	(
		String	instrument_name,
		BigDecimal	price,
		BigDecimal	amount
	)
	{
	}
}
