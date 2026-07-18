package temporal.deribit.notifications;

import java.math.BigDecimal;

import temporal.deribit.dto.Direction;
import java.io.Serializable;

public record block_rfq_trades
(
	int	id,
	long	timestamp,
	Direction	direction,
	BigDecimal	amount,
	BigDecimal	mark_price,
	Object	legs,
	String	combo_id,
	Object	hedge,
	Object	trades
)
implements Serializable {
}
