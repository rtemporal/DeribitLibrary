package temporal.deribit.notifications;

import java.math.BigDecimal;

import temporal.deribit.dto.TransactionLog.Role;
import java.io.Serializable;

public record block_rfq_maker
(
	long	creation_timestamp,
	long	expiration_timestamp,
	int	block_rfq_id,
	Role	role,
	State	state,
	String	taker_rating,
	BigDecimal	amount,
	BigDecimal	min_trade_amount,
	Object	legs,
	Object	hedge,
	String	combo_id,
	boolean	disclosed,
	String	taker,
	Object	index_prices,
	boolean	included_in_taker_rating,
	Object	trades
)
implements Serializable {
	public enum State
	{
		open, filled, cancelled, expired
	}
}
