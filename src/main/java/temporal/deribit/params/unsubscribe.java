package temporal.deribit.params;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record unsubscribe
(
	@JsonUnwrapped
	Authorization	authorization,
	List<String>	channels
)
{
}
