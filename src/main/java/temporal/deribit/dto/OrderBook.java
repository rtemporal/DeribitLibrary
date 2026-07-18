package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record OrderBook
(
	String	instrument_name,
	long	timestamp,
	State	state,
	Stats	stats,
	BigDecimal	open_interest,
	BigDecimal	best_bid_price,
	BigDecimal	best_bid_amount,
	BigDecimal	best_ask_price,
	BigDecimal	best_ask_amount,
	BigDecimal	index_price,
	BigDecimal	min_price,
	BigDecimal	max_price,
	BigDecimal	mark_price,
	BigDecimal	last_price,
	BigDecimal[][]	bids,
	BigDecimal[][]	asks,
	BigDecimal	underlying_price,
	BigDecimal	underlying_index,
	BigDecimal	interest_rate,
	BigDecimal	bid_iv,
	BigDecimal	ask_iv,
	BigDecimal	mark_iv,
	Greeks	greeks,
	BigDecimal	funding_8h,
	BigDecimal	current_funding,
	BigDecimal	delivery_price,
	BigDecimal	settlement_price
)
implements Serializable {
	public enum State
	{
		open,
		settlement,
		delivered,
		inactive,
		locked,
		halted,
		archivized
	}

	public record Stats
	(
		BigDecimal	volume,
		BigDecimal	low,
		BigDecimal	high,
		BigDecimal	price_change,
		BigDecimal	volume_usd
	)
implements Serializable {
	}
}
