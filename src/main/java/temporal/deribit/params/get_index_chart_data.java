package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_index_chart_data
(
	@JsonUnwrapped
	Authorization	authorization,
	String	index_name,
	String	range
)
{
}
