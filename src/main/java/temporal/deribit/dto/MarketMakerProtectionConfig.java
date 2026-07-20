package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record MarketMakerProtectionConfig
(
	IndexName	index_name,
	int	interval,
	int	frozen_time,
	String	mmp_group,
	BigDecimal	quantity_limit,
	BigDecimal	delta_limit,
	BigDecimal	vega_limit,
	BigDecimal	max_quote_quantity,
	Boolean	block_rfq,
	Integer	trade_count_limit
)
implements Serializable
{
}
