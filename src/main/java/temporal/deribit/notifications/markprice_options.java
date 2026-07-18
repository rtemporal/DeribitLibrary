package temporal.deribit.notifications;

import java.math.BigDecimal;
import java.io.Serializable;

public record markprice_options
(
	String	instrument_name,
	float	iv,
	BigDecimal	mark_price,
	long	timestamp
)
implements Serializable {
}
