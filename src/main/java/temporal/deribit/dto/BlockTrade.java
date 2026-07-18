package temporal.deribit.dto;

import java.util.List;
import java.io.Serializable;

public record BlockTrade
(
	String	id,
	long	timestamp,
	List<Trade>	trades,
	String	app_name,
	String	broker_code,
	String	broker_name
)
implements Serializable {
}
