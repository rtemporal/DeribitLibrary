package temporal.deribit.dto;

import java.math.BigDecimal;
import java.util.List;
import java.io.Serializable;

public record BlockRfq
(
	Integer	block_rfq_id,
	String	role,
	String	state,
	BigDecimal	amount,
	BigDecimal	min_trade_amount,
	long	creation_timestamp,
	long	expiration_timestamp,
	List<Leg>	legs,
	List<Quote>	asks,
	List<Quote>	bids,
	Hedge	hedge,
	String	combo_id,
	String	label,
	String	app_name,
	BigDecimal	mark_price,
	Boolean	disclosed,
	String	taker,
	List<String>	makers,
	String	taker_rating,
	List<BigDecimal>	index_prices,
	Boolean	included_in_taker_rating,
	List<Trade>	trades,
	TradeTrigger	trade_trigger,
	List<TradeAllocation>	trade_allocations
)
implements Serializable {
	public record Leg
	(
		String	instrument_name,
		Direction	direction,
		Integer	ratio
	)
implements Serializable {
	}

	public record Quote
	(
		List<String>	makers,
		BigDecimal	price,
		BigDecimal	amount,
		long	last_update_timestamp,
		String	execution_instruction,
		Long	expires_at
	)
implements Serializable {
	}

	public record Hedge
	(
		String	instrument_name,
		Direction	direction,
		BigDecimal	price,
		BigDecimal	amount
	)
implements Serializable {
	}

	public record TradeTrigger
	(
		String	state,
		BigDecimal	price,
		Direction	direction,
		String	cancel_reason
	)
implements Serializable {
	}

	public record TradeAllocation
	(
		Integer	user_id,
		ClientInfo	client_info,
		BigDecimal	amount
	)
implements Serializable {
		public record ClientInfo
		(
			Integer	client_id,
			Integer	client_link_id,
			String	name
		)
implements Serializable {
		}
	}
}
