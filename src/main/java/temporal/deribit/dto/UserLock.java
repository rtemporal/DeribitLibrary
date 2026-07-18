package temporal.deribit.dto;

import java.io.Serializable;

public record UserLock
(
	Currency	currency,
	boolean	enabled,
	String	message
)
implements Serializable {
}
