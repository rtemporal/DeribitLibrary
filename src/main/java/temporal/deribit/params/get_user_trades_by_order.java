package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_user_trades_by_order
(
	@JsonUnwrapped
	Authorization	authorization,
	String	order_id,
	Sorting	sorting,
	Boolean	historical
)
{
}
