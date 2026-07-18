package temporal.deribit.notifications;

import java.math.BigDecimal;

import temporal.deribit.dto.Direction;
import java.io.Serializable;

public record block_rfq_maker_quotes
(
	long	creation_timestamp,
	long	last_update_timestamp,
	int	block_rfq_id,
	int	block_rfq_quote_id,
	String	quote_state,
	ExecutionInstruction	execution_instruction,
	BigDecimal	price,
	BigDecimal	amount,
	Direction	direction,
	BigDecimal	filled_amount,
	Object	legs,
	Object	hedge,
	boolean	replaced,
	String	label,
	String	app_name,
	String	quote_state_reason
)
implements Serializable {
	public enum ExecutionInstruction
	{
		any_part_of, all_or_none
	}
}
