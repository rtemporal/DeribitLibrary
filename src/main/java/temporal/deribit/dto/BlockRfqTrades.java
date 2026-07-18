package temporal.deribit.dto;

import java.math.BigDecimal;
import java.util.List;
import java.io.Serializable;

public record BlockRfqTrades
(
	List<BlockRfqTrade>	block_rfqs,
	String	continuation
)
implements Serializable {
	public record BlockRfqTrade
	(
		Integer	id,
		long	timestamp,
		Direction	direction,
		BigDecimal	amount,
		BigDecimal	mark_price,
		List<Leg>	legs,
		String	combo_id,
		BlockRfq.Hedge	hedge,
		Object	index_prices,
		List<Trade>	trades
	)
implements Serializable {
		public record Leg
		(
			String	instrument_name,
			Direction	direction,
			Integer	ratio,
			BigDecimal	price
		)
implements Serializable {
		}
	}
}
