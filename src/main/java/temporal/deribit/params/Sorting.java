package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Sorting
{
	asc,
	desc,
    @JsonProperty("default")
	_default
}