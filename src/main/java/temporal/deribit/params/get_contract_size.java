package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_contract_size
(
	@JsonUnwrapped
	Authorization	authorization,
	String	instrument_name
)
{
}
