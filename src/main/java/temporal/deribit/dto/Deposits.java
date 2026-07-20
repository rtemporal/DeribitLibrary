package temporal.deribit.dto;

import java.io.Serializable;

public record Deposits
(
	Deposit[]	data,
	int	count
)
implements Serializable
{
}
