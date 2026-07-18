package temporal.deribit.notifications;

import java.math.BigDecimal;

import temporal.deribit.dto.IndexName;
import java.io.Serializable;

public record deribit_volatility_index
(
	long	timestamp,
	BigDecimal	volatility,
	IndexName	index_name
)
implements Serializable {
}
