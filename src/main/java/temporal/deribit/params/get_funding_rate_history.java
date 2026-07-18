package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_funding_rate_history
(
	@JsonUnwrapped
	Authorization	authorization,
	String	instrument_name,
	long	start_timestamp,
	long	end_timestamp	
)
{
}
