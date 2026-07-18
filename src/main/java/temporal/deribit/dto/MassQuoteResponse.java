package temporal.deribit.dto;

import java.util.List;
import java.io.Serializable;

public record MassQuoteResponse
(
	List<Order>	orders,
	List<Trade>	trades,
	List<Error>	errors,
	Integer	errors_count,
	Integer	pending_requests_count,
	List<PendingRequest>	pending_requests
)
implements Serializable {
	public record Error
	(
		String	instrument_name,
		String	side,
		Integer	code,
		String	message,
		Object	error
	)
implements Serializable {
	}

	public record PendingRequest
	(
		String	instrument_name,
		String	side
	)
implements Serializable {
	}
}
