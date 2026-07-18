package temporal.deribit.notifications;

import java.io.Serializable;

public record OnClose(int	code, String	reason)
implements Serializable {
}
