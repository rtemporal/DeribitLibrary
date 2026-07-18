package temporal.deribit.notifications;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public record book
(
	String	instrument_name,
	int	change_id,
	Integer	prev_change_id,
	BigDecimal[]	asks,
	BigDecimal[]	bids,
	long	timestamp,
	Type	type
)
implements Serializable {
	public enum Type
	{
		snapshot,
		change	
	}
	
	public enum Group
	{
		none,
		@JsonProperty("1")
		_1,
		@JsonProperty("2")
		_2,
		@JsonProperty("5")
		_5,
		@JsonProperty("10")
		_10,
		@JsonProperty("25")
		_25,
		@JsonProperty("100")
		_100,
		@JsonProperty("250")
		_250		
	}
	
	public enum Depth
	{
		@JsonProperty("1")
		_1,
		@JsonProperty("2")
		_2,
		@JsonProperty("10")
		_10,
	}
}
