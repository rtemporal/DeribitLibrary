package temporal.deribit.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;

public record Order
(
	Boolean	quote,
	Boolean	triggered,
	Boolean	mobile,
	String	app_name,
	Float	implv,
	BigDecimal	refresh_amount,
	BigDecimal	usd,
	String[]	oto_order_ids,
	boolean	api,
	BigDecimal	average_price,
	Advanced	advanced,
	String	order_id,
	boolean	post_only,
	BigDecimal	filled_amount,
	Trigger	trigger,
	String	trigger_order_id,
	Direction	direction,
	BigDecimal	contracts,
	Boolean	is_secondary_oto,
	boolean	replaced,
	String	mmp_group,
	boolean	mmp,
	long	last_update_timestamp,
	long	creation_timestamp,
	CancelReason	cancel_reason,
	Boolean	mmp_cancelled,
	String	quote_id,
	State	order_state,
	Boolean	is_rebalance,
	Boolean	reject_post_only,
	String	label,
	Boolean	is_liquidation,
	BigDecimal	price,
	Boolean	web,
	TimeInForce	time_in_force,
	BigDecimal	trigger_reference_price,
	BigDecimal	display_amount,
	Type	order_type,
	Boolean	is_primary_otoco,
	Type	original_order_type,
	Boolean	block_trade,
	BigDecimal	trigger_price,
	String	oco_ref,
	BigDecimal	trigger_offset,
	String	quote_set_id,
	Boolean	auto_replaced,
	Boolean	reduce_only,
	BigDecimal	amount,
	boolean	risk_reducing,
	String	instrument_name,
	String	trigger_fill_condition,
	String	primary_order_id,
	/*
	 * Fields not documented.
	 */
	int	user_id
)

implements Serializable, OrderI
{
	public enum Advanced
	{
		usd,
		implv
	}

	public enum Trigger
	{
		index_price,
		mark_price,
		last_price
	}

	public enum CancelReason
	{
		user_request,
		autoliquidation,
		cancel_on_disconnect,
		risk_mitigation,
		pme_risk_reduction,
		pme_account_locked,
		position_locked,
		mmp_trigger,
		mmp_config_curtailment,
		edit_post_only_reject,
		reject_post_only,
		oco_other_closed,
		oto_primary_closed,
		settlement
	}

	public enum State
	{
		open,
		filled,
		rejected,
		cancelled,
		untriggered
	}

	public enum TimeInForce
	{
		good_til_cancelled,
		good_til_day,
		fill_or_kill,
		immediate_or_cancel
	}

	public enum Type
	{
		limit,
		market,
		stop_limit,
		stop_market
	}

	public static class MergeComparator implements Comparator<Order>
	{
		public int	compare(Order	lhs, Order	rhs)
		{
			int	compare;

			if ((compare = lhs.instrument_name().compareTo(rhs.instrument_name())) == 0)
				if ((compare = lhs.direction().compareTo(rhs.direction())) == 0)
					if ((compare = lhs.price().compareTo(rhs.price())) == 0)
						compare = lhs.amount().compareTo(rhs.amount());

			return compare;
		}
	}

	public BigDecimal	volume()
	{
		return amount.multiply(price);
	}

	public static class VolumeComparator implements Comparator<Order>
	{
		public int	compare(Order	lhs, Order	rhs)
		{
			BigDecimal	lhsVolume = lhs.volume();
			BigDecimal	rhsVolume = rhs.volume();

			return lhsVolume.subtract(rhsVolume).signum();
		}
	}

	public String	toString()
	{
		StringBuffer	stringBuffer = new StringBuffer(getClass().getSimpleName());

		stringBuffer.append(" [order_state=").append(order_state);
		stringBuffer.append(", direction=").append(direction);
		stringBuffer.append(", instrument_name=").append(instrument_name);
		stringBuffer.append(", amount=").append(amount);
		stringBuffer.append(", price=").append(price);
		stringBuffer.append(']');

		return stringBuffer.toString();
	}
}
