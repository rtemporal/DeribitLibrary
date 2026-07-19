package temporal.deribit.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public record MarkPricePoint
(
	long	timestamp,
	BigDecimal	price
)
implements Serializable
{
}
