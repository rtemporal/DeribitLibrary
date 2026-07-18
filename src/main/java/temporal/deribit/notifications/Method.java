package temporal.deribit.notifications;

import java.io.Serializable;

public record Method<T>(String	jsonrpc, String	method, T	params)
implements Serializable {
}
