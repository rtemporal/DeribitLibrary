package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_order_state
(
	@JsonUnwrapped
	Authorization	authorization,
	String	order_id
)
{
}
