package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.IndexName;

public record get_delivery_prices
(
	@JsonUnwrapped
	Authorization	authorization,
	IndexName	index_name,
	Integer	offset,
	Integer	count
)
{
}
