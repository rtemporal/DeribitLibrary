package temporal.deribit.notifications;

import java.io.Serializable;

public record Heartbeat
(
	Type	type
)
implements Serializable {
	public enum Type
	{
		heartbeat,
		test_request
	}
}
