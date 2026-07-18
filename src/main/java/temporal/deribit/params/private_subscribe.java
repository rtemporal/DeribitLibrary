package temporal.deribit.params;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record private_subscribe
(
	@JsonUnwrapped
	Authorization	authorization,
	String	label,
	List<String>	channels
)
{
}
