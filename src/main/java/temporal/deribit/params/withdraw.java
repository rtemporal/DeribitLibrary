package temporal.deribit.params;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record withdraw
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	String	address,
	BigDecimal	amount,
	Priority	priority
)
{
	public enum Priority
	{
		insane,
		extreme_high,
		very_high,
		high,
		mid,
		low,
		very_low
	}
}
