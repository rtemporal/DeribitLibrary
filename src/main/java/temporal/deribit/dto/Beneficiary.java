package temporal.deribit.dto;

import java.io.Serializable;

public record Beneficiary
(
	Currency	currency,
	String	address,
	Integer	user_id,
	boolean	agreed,
	boolean	personal,
	boolean	unhosted,
	String	beneficiary_vasp_name,
	String	beneficiary_vasp_did,
	String	beneficiary_address,
	long	created,
	long	updated,
	String	tag,
	String	beneficiary_first_name,
	String	beneficiary_last_name,
	String	beneficiary_company_name
)
implements Serializable {
}
