package temporal.deribit.dto;

import java.math.BigDecimal;
import java.util.List;
import java.io.Serializable;

public record BlockTradeRequest
(
	long	timestamp,
	String	nonce,
	String	role,
	List<Leg>	legs,
	Hedge	hedge,
	String	state
)
implements Serializable {
	public record Leg
	(
		String	instrument_name,
		BigDecimal	amount,
		Direction	direction
	)
implements Serializable {
	}

	public record Hedge
	(
		String	instrument_name,
		Direction	direction,
		BigDecimal	price,
		BigDecimal	amount
	)
implements Serializable {
	}
}
