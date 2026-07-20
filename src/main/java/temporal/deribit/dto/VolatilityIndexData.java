package temporal.deribit.dto;

import java.io.Serializable;
import java.util.List;

public record VolatilityIndexData
(
	List<VixCandle>	data,
	Long	continuation
)
implements Serializable
{
}
