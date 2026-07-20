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
	String[]	enabled_features,
	
	/**
	 * Fields not documented.
	 */
	String[]	ip_whitelist,
	String	public_key
)
implements Serializable
{
}
