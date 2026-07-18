package temporal.deribit.notifications;

import java.io.Serializable;

public record instrument_state
(
	long	timestamp,
	State	state,
	String	instrument_name
)
implements Serializable {
	public enum State
	{
		open, settlement, delivered, inactive, locked, halted, archivized
	}
}
