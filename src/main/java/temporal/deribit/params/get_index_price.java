package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.IndexName;

public record get_index_price
(
	@JsonUnwrapped
	Authorization	authorization,
	IndexName	index_name
)
{
}
