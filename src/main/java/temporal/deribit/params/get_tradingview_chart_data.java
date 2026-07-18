package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_tradingview_chart_data
(
	@JsonUnwrapped
	Authorization	authorization,
	String	instrument_name,
	Long	start_timestamp,
	Long	end_timestamp,
	Resolution	resolution
)
{
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
