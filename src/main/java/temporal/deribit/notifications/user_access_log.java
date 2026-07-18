package temporal.deribit.notifications;

import java.io.Serializable;

public record user_access_log
(
	int	id,
	String	ip,
	long	timestamp,
	String	country,
	String	city,
	Action	log,
	String	description
)
implements Serializable {
	public enum Action
	{
	    changed_email,
	    changed_password,
	    disabled_tfa,
	    enabled_tfa,
	    success,
	    failure,
	    enabled_subaccount_login,
	    disabled_subaccount_login,
	    new_api_key,
	    removed_api_key, 
	    changed_scope,
	    changed_whitelist,
	    disabled_api_key,
	    enabled_api_key,
	    reset_api_key
	}
}
