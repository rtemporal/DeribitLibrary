package temporal.deribit.params;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.IndexName;

public record set_mmp_config
(
	@JsonUnwrapped
	Authorization	authorization,
	IndexName	index_name,
	Integer	interval,
	Integer	frozen_time,
	String	mmp_group,
	BigDecimal	quantity_limit,
	BigDecimal	delta_limit,
	BigDecimal	vega_limit,
	BigDecimal	max_quote_quantity,
	Boolean	block_rfq,
	Short	trade_count_limit
)
{
}
