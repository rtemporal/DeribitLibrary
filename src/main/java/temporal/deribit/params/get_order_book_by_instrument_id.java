package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_order_book_by_instrument_id
(
	@JsonUnwrapped
	Authorization	authorization,
	int	instrument_id,
	Short	depth
)
{
}
