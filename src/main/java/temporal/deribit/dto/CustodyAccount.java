package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record CustodyAccount
(
	Currency	currency,
	Name	name,
	BigDecimal	pending_withdrawal_balance,
	BigDecimal	balance,
	Boolean	auto_deposit,
	String	client_id,
	String	external_id,
	String	withdrawal_address,
	Long	withdrawal_address_change,
	String	pending_withdrawal_address,
	String	deposit_address
)
implements Serializable {
	public enum Name
	{
		copper,
		cobo
	}
}
