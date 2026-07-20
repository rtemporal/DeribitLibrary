package temporal.deribit.dto;

import java.io.Serializable;

public record Transfers
(
	Transfer[]	data,
	int	count
)
implements Serializable
{
}
