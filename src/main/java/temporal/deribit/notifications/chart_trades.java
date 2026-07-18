package temporal.deribit.notifications;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public record chart_trades
(
	long	tick,
	BigDecimal	volume,
	BigDecimal	cost,
	BigDecimal	open,
	BigDecimal	close,
	BigDecimal	high,
	BigDecimal	low
)
implements Serializable {
	public enum Resolution
	{
		@JsonProperty("1")
		_1,
		@JsonProperty("3")
		_3,
		@JsonProperty("5")
		_5,
		@JsonProperty("10")
		_10,
		@JsonProperty("15")
		_15,
		@JsonProperty("30")
		_30,
		@JsonProperty("60")
		_60,
		@JsonProperty("120")
		_120,
		@JsonProperty("180")
		_180,
		@JsonProperty("360")
		_360,
		@JsonProperty("720")
		_720,
		@JsonProperty("1D")
		_1D
	}
}
