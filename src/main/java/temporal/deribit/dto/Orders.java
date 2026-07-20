package temporal.deribit.dto;

import java.io.Serializable;

public record Orders
(
	Order[]	entries,
	String	continuation
)
implements Serializable
{
}
