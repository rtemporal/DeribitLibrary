package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record LastTrade
(
	String	trade_id,
	int	trade_seq,
	String	instrument_name,
	long	timestamp,
	Direction	direction,
	short	tick_direction,
	BigDecimal	index_price,
	BigDecimal	price,
	BigDecimal	amount,
	BigDecimal	mark_price,
	BigDecimal	contracts,
	BigDecimal	iv,
	Liquidation	liquidation,
	String	block_trade_id,
	Integer	block_trade_leg_count,
	String	combo_id,
	BigDecimal	combo_trade_id,
	Integer	block_rfq_id
)
implements Serializable {
	public enum Liquidation
	{
		M,
		T,
		MT
	}
}
