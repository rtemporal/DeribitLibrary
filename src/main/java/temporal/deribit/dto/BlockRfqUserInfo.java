package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record BlockRfqUserInfo
(
	String	alias,
	Integer	rating,
	Integer	completed_trades_period,
	Integer	total_completed_trades,
	BigDecimal	volume_period
)
implements Serializable {
}
