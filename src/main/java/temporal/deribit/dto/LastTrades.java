package temporal.deribit.dto;

import java.io.Serializable;

public record LastTrades
(
	LastTrade[]	trades,
	boolean	has_more
)
implements Serializable
{
}
