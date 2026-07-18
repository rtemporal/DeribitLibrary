package temporal.deribit.dto;

import java.io.Serializable;

public record Authorization
(
	String	access_token,
	String[]	enabled_features,
	int	expires_in,
	Boolean	google_login,
	String	mandatory_tfa_status,
	String	refresh_token,
	String	scope,
	String	sid,
	String	state,
	TokenType	token_type
)
implements Serializable {
	public enum TokenType
	{
		bearer
	}
}
