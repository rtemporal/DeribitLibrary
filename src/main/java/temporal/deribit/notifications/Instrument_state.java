package temporal.deribit.notifications;

import java.io.Serializable;

public record Instrument_state
(
	String	instrument_name,
	State	state,
	long	timestamp
)
implements Serializable {
	public enum State
	{
		created,
		started,
		settled,
		closed,
		deactivated,
		terminated
	}
}
