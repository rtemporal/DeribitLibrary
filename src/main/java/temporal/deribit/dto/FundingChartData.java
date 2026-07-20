package temporal.deribit.dto;

import java.math.BigDecimal;
import java.util.List;
import java.io.Serializable;

public record FundingChartData
(
	BigDecimal	current_interest,
	BigDecimal	interest_8h,
	List<DataPoint>	data
)
implements Serializable
{
	public record DataPoint
	(
		long	timestamp,
		BigDecimal	index_price,
		BigDecimal	interest_8h
	)
implements Serializable
{
	}
}
