package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record set_disabled_trading_products
(
	@JsonUnwrapped
	Authorization	authorization,
	int	user_id,
	TradingProduct[]	trading_products
)
{
	public enum TradingProduct
	{
		perpetual,
		futures,
		options,
		future_combos,
		option_combos,
		spots
	}
}
