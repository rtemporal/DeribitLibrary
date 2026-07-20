package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record PositionMove
(
	String	instrument_name,
	Direction	direction,
	BigDecimal	price,
	BigDecimal	amount,
	Integer	source_uid,
	Integer	target_uid
)
implements Serializable
{
}
