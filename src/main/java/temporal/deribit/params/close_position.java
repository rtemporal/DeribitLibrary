package temporal.deribit.params;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record close_position
(
	@JsonUnwrapped
	Authorization	authorization,
	String	insrtument_name,
	Type	type,
	BigDecimal	price
)
{
	public enum Type
	{
		limit,
		market
	}
}
