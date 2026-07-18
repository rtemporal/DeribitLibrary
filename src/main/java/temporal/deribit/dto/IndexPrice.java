package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record IndexPrice
(
	BigDecimal	estimated_delivery_price,
	BigDecimal	index_price
)
implements Serializable {
}
