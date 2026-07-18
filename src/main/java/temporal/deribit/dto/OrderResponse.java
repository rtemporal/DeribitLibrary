package temporal.deribit.dto;

import java.io.Serializable;

public record OrderResponse
(
	Order	order,
	Trade[]	trades
)
implements Serializable {
}
