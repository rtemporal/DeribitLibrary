package temporal.deribit.dto;

import java.io.Serializable;

public record Response<T>
(
	String jsonrpc,
	int	id,
	T	result,
	Error	error,
	long usIn,
	long usOut,
	long usDiff,
	boolean	testnet
)
implements Serializable {
	public Response(int	id, T	result)
	{
		this("2.0", id, result, null, 0, 0, 0, false);
	}

	public record Error
	(
		int	code,
		String	message,
		Object	data
	)
implements Serializable {
	}
}
