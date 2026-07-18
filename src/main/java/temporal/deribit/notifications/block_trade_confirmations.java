package temporal.deribit.notifications;

import temporal.deribit.dto.TransactionLog.Role;
import java.io.Serializable;

public record block_trade_confirmations
(
	String	nonce,
	long	timestamp,
	Object	trades,
	String	app_name,
	String	username,
	Role	role,
	int	user_id,
	String	broker_code,
	String	broker_name,
	Object	state,
	Object	counterparty_state,
	String	combo_id
)
implements Serializable {
}
