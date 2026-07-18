package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record AccountSumaries
(
	int	id,
	String	system_name,
	String	username,
	Type	type,
	String	email,
	boolean	security_keys_enabled,
	boolean	login_enabled,
	boolean	mmp_enabled,
	boolean	interuser_transfers_enabled,
	String	referrer_id,
	Integer	creation_timestamp,
	String	self_trading_reject_mode,
	String	self_trading_extended_to_subaccounts,
	String	block_rfq_self_match_prevention,
	BigDecimal	affiliate_promotion_fee,
	Object	trading_products_details,
	Boolean	receive_notifications,
	AccountSummary[]	summaries
)
implements Serializable {
	public enum Type
	{
		main,
		subaccount
	}
}
