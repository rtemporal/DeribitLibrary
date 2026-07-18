package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record AnnualPercentageRate
(
	long	day,
	BigDecimal	apr
)
implements Serializable {
}
