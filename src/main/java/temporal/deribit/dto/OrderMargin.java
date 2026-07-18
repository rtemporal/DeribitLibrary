package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record OrderMargin
(
		String	order_id,
		BigDecimal	initial_margin,
		Currency	initial_margin_currency
)
implements Serializable {
}
