package temporal.deribit.dto;

import java.io.Serializable;

public record VolatilityIndexData
(
	Object[][]	data,
	Long	continuation
)
implements Serializable {
}
