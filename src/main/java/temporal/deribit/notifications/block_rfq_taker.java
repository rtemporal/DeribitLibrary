package temporal.deribit.notifications;

import java.math.BigDecimal;

import temporal.deribit.dto.TransactionLog.Role;
import java.io.Serializable;

public record block_rfq_taker
(
	long	creation_timestamp,
	long	expiration_timestamp,
	int	block_rfq_id,
	Role	role,
	State	state,
	String	taker_rating,
	Object	makers,
	BigDecimal	amount,
	BigDecimal	min_trade_amount,
	BigDecimal[]	asks,
	BigDecimal[]	bids,
	Object	legs,
	Object	hedge,
	String	combo_id,
	String	label,
	String	app_name,
	BigDecimal	mark_price,
	boolean	disclosed,
	String	taker,
	Object	index_prices,
	boolean	included_in_taker_rating,
	Object	trades,
	Object	trade_trigger,
	Object	trade_allocations
)
implements Serializable {
	public enum State
	{
		open, filled, cancelled, expired
	}
}
