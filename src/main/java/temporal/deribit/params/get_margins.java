package temporal.deribit.params;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_margins
(
	@JsonUnwrapped
	Authorization	authorization,
	String	instrument_name,
	BigDecimal	amount,
	BigDecimal	price
)
{
}
