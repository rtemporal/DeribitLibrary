package temporal.deribit.notifications;

import java.math.BigDecimal;
import java.io.Serializable;

public record estimated_expiration_price
(
	BigDecimal	seconds,
	BigDecimal	price,
	boolean	is_estimated,
	BigDecimal	left_ticks,
	BigDecimal	total_ticks
)
implements Serializable {
}
