package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record BookSummary
(
	String	instrument_name,
	BigDecimal	high,
	BigDecimal	low,
	Currency	base_currency,
	Currency	quote_currency,
	BigDecimal	volume,
	BigDecimal	bid_price,
	BigDecimal	ask_price,
	BigDecimal	mid_price,
	BigDecimal	mark_price,
	BigDecimal	last,
	BigDecimal	open_interest,
	long	creation_timestamp,
	BigDecimal	estimated_delivery_price,
	BigDecimal	volume_usd,
	BigDecimal	volume_notional,
	BigDecimal	current_funding,
	BigDecimal	funding_8h,
	BigDecimal	mark_iv,
	BigDecimal	interest_rate,
	String	underlying_index,
	BigDecimal	underlying_price,
	BigDecimal	price_change
)
implements Serializable
{
}
