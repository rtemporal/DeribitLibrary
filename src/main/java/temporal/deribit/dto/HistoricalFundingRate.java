package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record HistoricalFundingRate
(
	long	timestamp,
	BigDecimal	prev_index_price,
	BigDecimal	index_price,
	BigDecimal	interest_1h,
	BigDecimal	interest_8h
)
implements Serializable {
}
