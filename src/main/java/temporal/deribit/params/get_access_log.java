package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_access_log
(
	@JsonUnwrapped
	Authorization	authorization,
	Integer	offset,
	Short	count
)
{
}
