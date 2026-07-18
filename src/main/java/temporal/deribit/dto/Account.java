package temporal.deribit.dto;

import java.io.Serializable;

public record Account
(
	String	username,
	Type	type,
	int	id,
	String	email,
	String	system_name,
	boolean	receive_notifications,
	Boolean	is_password,
	String	not_confirmed_email,
	Boolean	security_keys_enabled,
	String[]	security_keys_assignments,
	String	margin_model,
	String	proof_id,
	String	proof_id_signature,
	Boolean	login_enabled,
	Object	portfolio,

	/**
	 * Non documented fields.
	 */
	Object	disabled_trading_products,
	Object	trading_products_details,
	Object	referrals_count
)
implements Serializable {
	public enum Type
	{
		main,
		subaccount
	}
}
