package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record change_margin_model
(
	@JsonUnwrapped
	Authorization	authorization,
	int	user_id,
	Boolean	dry_run
)
{
	public enum margin_model
	{
		cross_pm,
		cross_sm,
		segregated_pm,
		segregated_sm
	}
}
