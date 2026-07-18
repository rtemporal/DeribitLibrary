package temporal.deribit.params;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Direction;

public record submit_order
(
	@JsonUnwrapped
	Authorization	authorization,
	String	instrument_name,
	BigDecimal	amount,
	BigDecimal	contracts,
	Type	type,
	String	label,
	BigDecimal	price,
	TimeInForce	time_in_force,
	BigDecimal	display_amount,
	Boolean	post_only,
	Boolean	reject_post_only,
	Boolean	reduce_only,
	BigDecimal	trigger_price,
	BigDecimal	trigger_offset,
	Trigger	trigger,
	Advanced	advanced,
	Boolean	mmp,
	Long	valid_until,
	LinkedOrderType	linked_order_type,
	TriggerFillCondition	trigger_fill_condition,
	OtocoConfig[]	otoco_config
)
{
	public submit_order(Authorization	authorization, String	instrument_name, BigDecimal	amount, BigDecimal	price, Type	type, TimeInForce	timeInForce, Boolean	post_only)
	{
		this
		(
			authorization,
			instrument_name,
			amount,
			null,
			type,
			null,
			price,
			null,
			null,
			post_only,
			null,
			null,
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

	public submit_order(Authorization	authorization, String	instrument_name, BigDecimal	amount, BigDecimal	price, Type	type, TimeInForce	timeInForce, Advanced	advanced)
	{
		this
		(
			authorization,
			instrument_name,
			amount,
			null,
			type,
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
			advanced,
			null,
			null,
			null,
			null,
			null
		);
	}

	public enum Type
	{
		limit,
		stop_limit,
		take_limit,
		market,
		stop_market,
		take_market,
		market_limit,
		trailing_stop
	}

	public enum TimeInForce
	{
		good_til_cancelled,
		good_til_day,
		fill_or_kill,
		immediate_or_cancel
	}

	public enum Trigger
	{
		index_price,
		mark_price,
		last_price
	}

	public enum Advanced
	{
		usd,
		implv
	}

	public enum LinkedOrderType
	{
		one_triggers_other,
		one_cancels_other,
		one_triggers_one_cancels_other
	}

	public enum TriggerFillCondition
	{
		first_hit,
		complete_fill,
		incremental
	}

	public record OtocoConfig
	(
		BigDecimal	amount,
		Direction	direction,
		Type	type,
		String	label,
		BigDecimal	price,
		Boolean	reduce_only,
		TimeInForce	time_in_force,
		Boolean	post_only,
		Boolean	reject_post_only,
		BigDecimal	trigger_price,
		BigDecimal	trigger_offset,
		Trigger	trigger
	)
	{	
	}

	public String	toString()
	{
		StringBuffer	stringBuffer = new StringBuffer(getClass().getSimpleName());

		stringBuffer.append(" [type=").append(type);
		stringBuffer.append(", instrument_name=").append(instrument_name);
		stringBuffer.append(", amount=").append(amount);
		stringBuffer.append(", price=").append(price);
		stringBuffer.append(']');

		return stringBuffer.toString();
	}
}
