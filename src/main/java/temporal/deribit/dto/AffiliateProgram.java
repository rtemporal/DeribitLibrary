package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record AffiliateProgram
(
	boolean	is_enabled,
	BigDecimal	number_of_affiliates,
	String	link,
	Received	received
)
implements Serializable {
	public record Received
	(
		BigDecimal	eth,
		BigDecimal	btc
	)
implements Serializable {
	}
}
