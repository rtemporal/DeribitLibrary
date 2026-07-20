package temporal.deribit.dto;

import java.io.Serializable;

public record TransactionLogs
(
	Integer	continuation,
	TransactionLog[]	logs
)
implements Serializable
{
}
