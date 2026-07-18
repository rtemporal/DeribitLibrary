package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_funding_chart_data
(
	@JsonUnwrapped
	Authorization	authorization,
	String	instrument_name,
	String	length
)
{
}
