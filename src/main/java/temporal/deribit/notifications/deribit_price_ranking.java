package temporal.deribit.notifications;

import java.math.BigDecimal;
import java.io.Serializable;

public record deribit_price_ranking
(
	String	identifier,
	boolean	enabled,
	BigDecimal	original_price,
	BigDecimal	price,
	long	timestamp,
	BigDecimal	weight
)
implements Serializable {
}
