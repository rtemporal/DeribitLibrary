package temporal.deribit.notifications;

import temporal.deribit.dto.Currency;
import java.io.Serializable;

public record user_lock
(
	Currency	currency,
	boolean	locked
)
implements Serializable {
}
