package temporal.deribit.notifications;

import java.math.BigDecimal;

import temporal.deribit.dto.Currency;
import temporal.deribit.dto.Direction;
import java.io.Serializable;

public record user_trades
(		
	String	trade_id,
	short	tick_direction,
	Currency	fee_currency,
	boolean	api,
	Advanced	advanced,
	String	order_id,
	String	liquidity,
	boolean	post_only,
	Direction	direction,
	BigDecimal	contracts,
	boolean	mmp,
	BigDecimal	fee,
	String	quote_id,
	BigDecimal	index_price,
	String	label,
	String	block_trade_id,
	BigDecimal	price,
	String	combo_id,
	String	matching_id,
	OrderType	order_type,
	Allocation[]	trade_allocations,
	BigDecimal	profit_loss,
	long	timestamp,
	Float	iv,
	State	state,
	BigDecimal	underlying_price,
	Integer	block_rfq_quote_id,
	String	quote_set_id,
	BigDecimal	mark_price,
	Integer	block_rfq_id,
	BigDecimal	combo_trade_id,
	Boolean	reduce_only,
	BigDecimal	amount,
	Liquidation	liquidation,
	int	trade_seq,
	boolean	risk_reducing,
	String	instrument_name,
	/*
	 * Fields not documented.
	 */
	int	user_id,
	boolean	self_trade
)
implements Serializable {
	public enum Advanced
	{
		usd,
		implv
	}

	public enum OrderType
	{
		limit,
		market,
		liquidation
	}

	public record Allocation
	(
		BigDecimal	amount,
		BigDecimal	fee,
		Integer	user_id
	)
implements Serializable {	
	}

	public enum State
	{
		open,
		filled,
		rejected,
		cancelled,
		untriggered,
		archive
	}

	public enum Liquidation
	{
		M,
		T,
		MT
	}

	public BigDecimal	volume()
	{
		return amount.multiply(price);
	}
}
