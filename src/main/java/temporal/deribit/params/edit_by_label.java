package temporal.deribit.params;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record edit_by_label
(
	@JsonUnwrapped
	Authorization	authorization,
	String	label,
	String	instrument_name,
	BigDecimal	amount,
	BigDecimal	contracts,
	BigDecimal	price,
	Boolean	post_only,
	Boolean	reduce_only,
	Boolean	reject_post_only,
	Advanced	advanced,
	BigDecimal	trigger_price,
	Boolean	mmp,
	Long	valid_until
)
{
	public edit_by_label(Authorization	authorization, edit_by_label	edit_by_label)
	{
		this
		(
			authorization,
			edit_by_label.label,
			edit_by_label.instrument_name,
			edit_by_label.amount,
			edit_by_label.contracts,
			edit_by_label.price,
			edit_by_label.post_only,
			edit_by_label.reduce_only,
			edit_by_label.reject_post_only,
			edit_by_label.advanced,
			edit_by_label.trigger_price,
			edit_by_label.mmp,
			edit_by_label.valid_until
		);
	}

	public enum Advanced
	{
		usd,
		implv
	}
}
