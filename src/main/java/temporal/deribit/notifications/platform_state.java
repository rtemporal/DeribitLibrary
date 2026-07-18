package temporal.deribit.notifications;

import temporal.deribit.dto.IndexName;
import java.io.Serializable;

public record platform_state
(
	IndexName	price_index,
	boolean	locked,
	boolean	maintenance
)
implements Serializable {
}
