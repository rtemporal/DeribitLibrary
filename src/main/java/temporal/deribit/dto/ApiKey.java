package temporal.deribit.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ApiKey
(
	long	timestamp,
	String	max_scope,
	int	id,
	boolean	enabled,
    @JsonProperty("default")
	boolean	_default,
	String	client_secret,
	String	client_id,
	String	name,
	Object	enabled_features,
	
	/**
	 * Fields not documented.
	 */
	Object	ip_whitelist,
	String	public_key
)
implements Serializable {
}
