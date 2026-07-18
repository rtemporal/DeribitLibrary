package temporal.deribit.params;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record mass_quote
(
	@JsonUnwrapped
	Authorization	authorization,
	String	quote_id,
	String	mmp_group,
	List<Quote>	quotes,
	Long	valid_until,
	Boolean	detailed,
	Boolean	wait_for_response
)
{
	public record Quote
	(
		String	instrument_name,
		String	quote_set_id,
		QuoteSide	ask,
		QuoteSide	bid
	)
	{
	}

	public record QuoteSide
	(
		BigDecimal	price,
		BigDecimal	amount,
		Boolean	post_only,
		Boolean	reject_post_only
	)
	{
	}
}
