package temporal.deribit.dto;

import java.io.Serializable;

public record CancelOnDisconnect
(
	String	scope,
	boolean	enabled
)
implements Serializable
{
}
