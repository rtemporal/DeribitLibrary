package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record Margin
(
	BigDecimal	buy,
	BigDecimal	max_price,
	BigDecimal	min_price,
	BigDecimal	sell
)
implements Serializable
{
}
