package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_trade_volumes
(
	@JsonUnwrapped
	Authorization	authorization,
	Boolean	extended
)
{
}
