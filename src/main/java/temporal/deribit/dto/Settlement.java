package temporal.deribit.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;

public record Settlement
(
	BigDecimal	funding,
	BigDecimal	index_price,
	String	instrument_name,
	BigDecimal	position,
	BigDecimal	session_profit_loss,
	long	timestamp,
	Type	type,
	BigDecimal	funded,
	BigDecimal	mark_price,
	BigDecimal	profit_loss,
	BigDecimal	session_bankruptcy,
	BigDecimal	session_tax,
	BigDecimal	session_tax_rate,
	BigDecimal	socialized
)
implements Serializable {
	public enum Type
	{
		settlement,
		delivery,
		bankruptcy,
		exercise
	}

	public static class TimestampComparator implements Comparator<Settlement>
	{
		public int	compare(Settlement	lhs, Settlement	rhs)
		{
			return Long.compare(lhs.timestamp(), rhs.timestamp());
		}
	}
}
