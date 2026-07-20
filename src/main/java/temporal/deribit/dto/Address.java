package temporal.deribit.dto;

import java.io.Serializable;

public record Address
(
	Currency	currency,
	String	address,
	long	creation_timestamp,
	Type	type,
	String	label,
	String	beneficiary_vasp_name,
	String	beneficiary_vasp_did,
	String	beneficiary_vasp_website,
	String	beneficiary_first_name,
	String	beneficiary_last_name,
	String	beneficiary_company_name,
	String	beneficiary_address,
	Boolean	agreed,
	Boolean	personal,
	Boolean	info_required,
	Status	status,
	Boolean	waiting_timestamp,
	Boolean	requires_confirmation,
	Boolean	requires_confirmation_change
)
implements Serializable
{
	public enum Type
	{
		transfer,
		withdrawal,
		deposit_source,
		deposit
	}
	
	public enum Status
	{
		admin_locked,
		waiting,
		confirmed,
		ready
	}
}
