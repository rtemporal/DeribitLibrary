package temporal.deribit.params;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record edit_order
(
	@JsonUnwrapped
	Authorization	authorization,
	String	order_id,
	BigDecimal	amount,
	BigDecimal	contracts,
	BigDecimal	price,
	Boolean	post_only,
	Boolean	reduce_only,
	Boolean	reject_post_only,
	Advanced	advanced,
	BigDecimal	trigger_price,
	BigDecimal	trigger_offset,
	Boolean	mmp,
	Long	valid_until,
	BigDecimal	display_amount
)
{
	public edit_order(Authorization	authorization, String	order_id, BigDecimal	amount, BigDecimal	price)
	{
		this
		(
			authorization,
			order_id,
			amount,
			null,
			price,
			null,
			null,
			null,
			null,
			null,
			null,
			null,
			null,
			null
		);
	}

	public enum Advanced
	{
		usd,
		implv
	}
}
