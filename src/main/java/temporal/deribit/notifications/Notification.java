package temporal.deribit.notifications;

import java.io.Serializable;

public record Notification<T>(String	jsonrpc, String	method, Params<T>	params)
implements Serializable {
	public Notification(Params<T>	params)
	{
		this("2.0", "subscription", params);
	}

	public record Params<T>
	(
		String	channel,
		String	label,
		T	data
	)
implements Serializable {
	}
}
