package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record DeliveryPrices(Data[]	data, BigDecimal	records_total)
implements Serializable {
	public record Data(String	date, BigDecimal	delivery_price)
	implements Serializable {
	}
}
