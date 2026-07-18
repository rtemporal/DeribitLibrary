package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record edit_api_key
(
	@JsonUnwrapped
	Authorization	authorization,
	int	id,
	String[]	max_scope,
	String	name,
	Boolean	enabled,
	Feature[]	enabled_features,
	String[]	ip_whitelist
)
{
	public enum Feature
	{
		restricted_block_trades,
		block_trade_approval
	}
}
