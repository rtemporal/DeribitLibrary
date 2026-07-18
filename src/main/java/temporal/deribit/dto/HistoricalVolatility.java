package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record HistoricalVolatility
(
	long	timestamp,
	BigDecimal	value
)
implements Serializable {
}
