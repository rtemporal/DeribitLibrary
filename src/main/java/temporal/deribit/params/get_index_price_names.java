package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_index_price_names
(
	@JsonUnwrapped
	Authorization	authorization,
	Boolean	extended
)
{
}
