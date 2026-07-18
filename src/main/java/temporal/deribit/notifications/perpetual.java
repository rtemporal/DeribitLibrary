package temporal.deribit.notifications;

import java.math.BigDecimal;
import java.io.Serializable;

public record perpetual
(
	BigDecimal	interest,
	long	timestamp,
	BigDecimal	index_price
)
implements Serializable {
}
