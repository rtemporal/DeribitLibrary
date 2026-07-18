package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record TradeVolume
(
	Currency	currency,
	BigDecimal	calls_volume,
	BigDecimal	puts_volume,
	BigDecimal	futures_volume,
	BigDecimal	spot_volume,
	BigDecimal	calls_volume_7d,
	BigDecimal	puts_volume_7d,
	BigDecimal	futures_volume_7d,
	BigDecimal	spot_volume_7d,
	BigDecimal	calls_volume_30d,
	BigDecimal	puts_volume_30d,
	BigDecimal	futures_volume_30d,
	BigDecimal	spot_volume_30d
)
implements Serializable {
}
