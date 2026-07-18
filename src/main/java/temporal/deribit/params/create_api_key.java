package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record create_api_key
(
	@JsonUnwrapped
	Authorization	authorization,
	String[]	max_scope,
	String	name,
	String	public_key,
	Feature[]	enabled_features
)
{
	public enum Feature
	{
		restricted_block_trades,
		block_trade_approval
	}
}
