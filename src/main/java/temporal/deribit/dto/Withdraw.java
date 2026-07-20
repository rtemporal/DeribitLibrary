package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record Withdraw
(
	String	address,
	BigDecimal	amount,
	Currency	currency,
	State	state,
	String	transaction_id,
	long	updated_timestamp,
	Long	confirmed_timestamp,
	Long	created_timestamp,
	BigDecimal	fee,
	int	id,
	short	priority
)
implements Serializable
{
	public enum State
	{
		unconfirmed,
		confirmed,
		cancelled,
		completed,
		interrupted,
		rejected
	}
}
