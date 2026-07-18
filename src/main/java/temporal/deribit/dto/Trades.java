package temporal.deribit.dto;

import java.io.Serializable;

public record Trades
(
	Trade[]	trades,
	boolean	has_more
)
implements Serializable {
}
