package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_order_margin_by_ids
(
	@JsonUnwrapped
	Authorization	authorization,
	String[]	ids
)
{
}
