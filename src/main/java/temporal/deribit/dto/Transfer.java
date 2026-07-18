package temporal.deribit.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;

public record Transfer
(
	int	id,
	Type	type,
	String	state,
	Currency	currency,
	BigDecimal	amount,
	Direction	direction,
	String	note,
	String	other_side,
	long	created_timestamp,
	long	updated_timestamp
)
implements Serializable {
	public enum Type
	{
		user,
		subaccount
	}
	
	public enum Direction
	{
		payment, 
		income
	}

	public static class IdComparator implements Comparator<Transfer>
	{
		public int	compare(Transfer	lhs, Transfer	rhs)
		{
			return Integer.compare(lhs.id, rhs.id);
		}
	}

	public static class CreatedTimestampComparator implements Comparator<Transfer>
	{
		public int	compare(Transfer	lhs, Transfer	rhs)
		{
			return Long.compare(lhs.created_timestamp, rhs.created_timestamp);
		}
	}
}
