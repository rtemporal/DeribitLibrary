package temporal.deribit.dto;

import java.io.Serializable;

public record Withdraws
(
	Withdraw[]	data,
	int	count
)
implements Serializable
{
}
