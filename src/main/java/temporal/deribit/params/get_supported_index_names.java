package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_supported_index_names
(
	@JsonUnwrapped
	Authorization	authorization,
	Type	type
)
{
	public enum Type
	{
		all,
		spot,
		derivative
	}
}
