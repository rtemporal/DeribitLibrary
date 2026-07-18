package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record set_self_trading_config
(
	@JsonUnwrapped
	Authorization	authorization,
	Mode	mode,
	boolean	extended_to_subaccounts,
	Boolean	block_rfq_self_match_prevention
)
{
	public enum Mode
	{
		reject_taker,
		cancel_maker
	}
}
