package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record Combo
(
	String	id,
	Integer	instrument_id,
	State	state,
	long	state_timestamp,
	long	creation_timestamp,
	Leg[]	legs
)
implements Serializable {
	public enum State
	{
		active,
		inactive		
	}

	public record Leg
	(
		String	instrument_name,
		BigDecimal	amount
	)
implements Serializable {
	}
}
