package temporal.deribit.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public record Instrument
(
	Currency	base_currency,
	BigDecimal	block_trade_commission,
	BigDecimal	block_trade_min_trade_amount,
	BigDecimal	block_trade_tick_size,
	int	contract_size,
	Currency	counter_currency,
	long	creation_timestamp,
	long	expiration_timestamp,
	int	instrument_id,
	String	instrument_name,
	Type	instrument_type,
	boolean	is_active,
	Kind	kind,
	float	maker_commission,
	Short	max_leverage,
	BigDecimal	max_liquidation_commission,
	BigDecimal	min_trade_amount,
	OptionType	option_type,
	IndexName	price_index,
	Currency	quote_currency,
	Currency	settlement_currency,
	String	settlement_period,
	BigDecimal	strike,
	float	taker_commission,
	BigDecimal	tick_size,
	TickSizeStep[]	tick_size_steps
)
implements Serializable
{
	public enum Type
	{
		linear,
		reversed
	}

	public enum OptionType
	{
		call,
		put
	}

	public record TickSizeStep
	(
		BigDecimal	above_price,
		BigDecimal	tick_size
	)
implements Serializable
{
	}
}
