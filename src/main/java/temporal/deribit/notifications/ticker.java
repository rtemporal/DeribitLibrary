package temporal.deribit.notifications;

import java.math.BigDecimal;

import temporal.deribit.dto.Greeks;
import java.io.Serializable;

public record ticker
(
	BigDecimal	ask_iv,
	BigDecimal	best_ask_amount,
	BigDecimal	best_ask_price,
	BigDecimal	best_bid_amount,
	BigDecimal	best_bid_price,
	BigDecimal	bid_iv,
	BigDecimal	current_funding,
	BigDecimal	delivery_price,
	BigDecimal	estimated_delivery_price,
	BigDecimal	funding_8h,
	Greeks	greeks,
	BigDecimal	index_price,
	String	instrument_name,
	Float	interest_rate,
	Float	interest_value,
	BigDecimal	last_price,
	Float	mark_iv,
	BigDecimal	mark_price,
	BigDecimal	max_price,
	BigDecimal	min_price,
	BigDecimal	open_interest,
	BigDecimal	settlement_price,
	String	state,
	Stats	stats,
	long	timestamp,
	String	underlying_index,
	BigDecimal	underlying_price
)
implements Serializable {
	public record Stats
	(
		BigDecimal	high,
		BigDecimal	low,
		BigDecimal	price_change,
		BigDecimal	volume,
		BigDecimal	volume_usd,
		
		/*
		 * Not documented fields.
		 */
		
		BigDecimal	volume_notional
	)
implements Serializable {
	}
}
