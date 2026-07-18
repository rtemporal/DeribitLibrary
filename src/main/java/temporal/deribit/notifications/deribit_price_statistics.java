package temporal.deribit.notifications;

import java.math.BigDecimal;

import temporal.deribit.dto.IndexName;
import java.io.Serializable;

public record deribit_price_statistics
(
	IndexName	index_name,
	BigDecimal	low24h,
	BigDecimal	high24h,
	BigDecimal	change24h,
	boolean	fast_market
)
implements Serializable {
}
