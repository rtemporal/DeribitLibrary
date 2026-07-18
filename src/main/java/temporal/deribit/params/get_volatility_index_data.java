package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record get_volatility_index_data
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	Long	start_timestamp,
	Long	end_timestamp,
	Resolution	resolution
)
{
	public enum Resolution
	{
	    @JsonProperty("1")
		_1,
	    @JsonProperty("60")
		_60,
	    @JsonProperty("3600")
		_3600,
	    @JsonProperty("43200")
		_43200,
	    @JsonProperty("1D")
		_1D
	}
}
