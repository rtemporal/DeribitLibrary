package temporal.deribit.notifications;

import java.io.Serializable;

import temporal.deribit.dto.Order;
import temporal.deribit.dto.Position;
import temporal.deribit.dto.Trade;

public record user_changes
(
	String	instrument_name,
	Order[]	orders,
	Position[]	position,
	Trade[]	trades
)

implements Serializable {
}
