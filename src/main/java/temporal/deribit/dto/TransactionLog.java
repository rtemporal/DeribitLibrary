package temporal.deribit.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public record TransactionLog
(
	int	id,
	Currency	currency,
	long	timestamp,
	int	user_id,
	BigDecimal	commission,
	BigDecimal	cashflow,
	BigDecimal	balance,
	BigDecimal	change,
	int	user_seq,
	Type	type,
	String	username,
	Object	info,
	BigDecimal	equity,
	BigDecimal	mark_price,
	BigDecimal	settlement_price,
	BigDecimal	index_price,
	String	instrument_name,
	BigDecimal	position,
	Side	side,
	BigDecimal	amount,
	BigDecimal	price,
	Currency	price_currency,
	String	trade_id,
	String	order_id,
	Role	user_role,
	Role	fee_role,
	Boolean	profit_as_cashflow,
	BigDecimal	interest_pl,
	Integer	block_rfq_id,
	String	ip,
	BigDecimal	session_rpl,
	BigDecimal	session_upl,
	BigDecimal	total_interest_pl,
	BigDecimal	contracts
)
implements Serializable
{
	public enum Type
	{
		trade,
		deposit,
		withdrawal,
		settlement,
		delivery,
		transfer,
		swap,
		correction
	}
	
	public enum Side
	{
	    @JsonProperty("short")
		_short,
	    @JsonProperty("long")
		_long,
	    @JsonProperty("close sell")
		close_sell,
	    @JsonProperty("close buy")
		close_buy,
	    @JsonProperty("open sell")
		open_sell,
	    @JsonProperty("open buy")
		open_buy,
	}

	public enum Role
	{
		maker,
		taker
	}
}
