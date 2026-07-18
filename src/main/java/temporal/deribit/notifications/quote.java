package temporal.deribit.notifications;

import java.math.BigDecimal;
import java.io.Serializable;

public record quote
(
	long	timestamp,
	String	instrument_name,
	BigDecimal	best_bid_price,
	BigDecimal	best_ask_price,
	BigDecimal	best_bid_amount,
	BigDecimal	best_ask_amount
)
implements Serializable {
	public BigDecimal	best_bid_price()
	{
		return best_bid_price.signum() != 0 ? best_bid_price : null;
	}

	public BigDecimal	best_ask_price()
	{
		return best_ask_price.signum() != 0 ? best_ask_price : null;
	}

	public BigDecimal	best_bid_amount()
	{
		return best_bid_amount.signum() != 0 ? best_bid_amount : null;
	}

	public BigDecimal	best_ask_amount()
	{
		return best_ask_amount.signum() != 0 ? best_ask_amount : null;
	}
}
