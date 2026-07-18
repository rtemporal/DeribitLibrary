package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record MarginModelState
(
	BigDecimal	maintenance_margin_rate,
	BigDecimal	initial_margin_rate,
	BigDecimal	available_balance
)
implements Serializable {
}
