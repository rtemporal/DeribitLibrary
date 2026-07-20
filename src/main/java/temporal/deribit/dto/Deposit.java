package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record Deposit
(
	Currency	currency,
	String	address,
	BigDecimal	amount,
	State	state,
	String	transaction_id,
	long	received_timestamp,
	long	updated_timestamp,
	String	source_address,
	String	note,
	ClearanceState	clearance_state,
	String	refund_transaction_id
)
implements Serializable
{
	public enum State
	{
		pending,
		completed,
		rejected,
		replaced
	}

	public enum ClearanceState
	{
		in_progress,
		pending_admin_decision,
		pending_user_input,
		success,
		failed,
		cancelled,
		refund_initiated,
		refunded
	}
}
