package temporal.deribit.dto;

import java.io.Serializable;

public record BrokerClient
(
	Integer	id,
	String	name
)
implements Serializable
{
}
