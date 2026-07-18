package temporal.deribit.params;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record submit_transfer_to_user
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	BigDecimal	amount,
	String	destination
)
{
}
