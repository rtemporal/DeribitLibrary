package temporal.deribit.dto;

import java.io.Serializable;

public record Settlements
(
	String	continuation,
	Settlement[]	settlements
)
implements Serializable
{
}
