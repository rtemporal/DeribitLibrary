package temporal.deribit.dto;

import java.io.Serializable;

public record PositionClose
(
	Order	order,
	Trade[]	trades
)
implements Serializable {
}
