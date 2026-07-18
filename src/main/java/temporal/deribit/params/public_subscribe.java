package temporal.deribit.params;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record public_subscribe
(
	@JsonUnwrapped
	Authorization	authorization,
	List<String>	channels
)
{
}
