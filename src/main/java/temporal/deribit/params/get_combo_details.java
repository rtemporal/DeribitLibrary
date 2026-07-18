package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_combo_details
(
	@JsonUnwrapped
	Authorization	authorization,
	String	combo_id
)
{
}
