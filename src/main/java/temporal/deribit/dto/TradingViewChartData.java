package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record TradingViewChartData
(
	Status	status,
	long	[]ticks,
	BigDecimal	[]volume,
	BigDecimal	[]cost,
	BigDecimal	[]open,
	BigDecimal	[]close,
	BigDecimal	[]high,
	BigDecimal	[]low
)
implements Serializable
{
	public enum Status
	{
		ok,
		no_data
	}
}
