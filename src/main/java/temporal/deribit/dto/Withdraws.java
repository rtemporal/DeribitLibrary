package temporal.deribit.dto;

import java.io.Serializable;

public record Withdraws
(
	Deposit[]	data,
	int	count
)
implements Serializable {
}
