package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Kind;

public record cancel_all_by_currency_pair
(
	@JsonUnwrapped
	Authorization	authorization,
	CurrencyPair	currency_pair,
	Kind	kind,
	Type	type,
	Boolean	detailed
)
{
	public enum CurrencyPair
	{
		btc_usd,
		eth_usd,
		ada_usdc,
		algo_usdc,
		avax_usdc,
		bch_usdc,
		bnb_usdc,
		btc_usdc,
		btcdvol_usdc,
		buidl_usdc,
		doge_usdc,
		dot_usdc,
		eurr_usdc,
		eth_usdc,
		ethdvol_usdc,
		link_usdc,
		ltc_usdc,
		near_usdc,
		paxg_usdc,
		shib_usdc,
		sol_usdc,
		steth_usdc,
		ton_usdc,
		trump_usdc,
		trx_usdc,
		uni_usdc,
		usde_usdc,
		usyc_usdc,
		xrp_usdc,
		btc_usdt,
		eth_usdt,
		eurr_usdt,
		sol_usdt,
		steth_usdt,
		usdc_usdt,
		usde_usdt,
		btc_eurr,
		btc_usde,
		btc_usyc,
		eth_btc,
		eth_eurr,
		eth_usde,
		eth_usyc,
		steth_eth,
		paxg_btc,
	    @JsonProperty("drbfix-btc_usdc")
		drbfix_btc_usdc,
	    @JsonProperty("drbfix-eth_usdc")
		drbfix_eth_usdc
	}

	public enum Type
	{
		all,
		limit,
		trigger_all,
		stop,
		take,
		trailing_stop
	}
}
