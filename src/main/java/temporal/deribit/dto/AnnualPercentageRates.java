package temporal.deribit.dto;

import java.io.Serializable;

public record AnnualPercentageRates
(
	AnnualPercentageRate[]	data,
	String	continuation
)
implements Serializable {
}
