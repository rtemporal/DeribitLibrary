package temporal.deribit.notifications;

import java.io.Serializable;

public record public_methods_state
(
	boolean	allow_unauthenticated_public_requests
)
implements Serializable {
}
