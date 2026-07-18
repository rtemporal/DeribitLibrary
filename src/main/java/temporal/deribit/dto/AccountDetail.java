package temporal.deribit.dto;

import java.io.Serializable;

public record AccountDetail
(
	int	uid,
	Position[]	positions,
	Order[]	open_orders
)
implements Serializable {
}
