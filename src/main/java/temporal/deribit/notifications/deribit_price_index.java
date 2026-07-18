package temporal.deribit.notifications;

import java.io.Serializable;
import java.math.BigDecimal;

public record deribit_price_index
(
	String	index_name,
	BigDecimal	price,
	long	timestamp
)

implements Serializable {
}
