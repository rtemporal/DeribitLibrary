package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record save_address_beneficiary
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	String	address,
	String	tag,
	boolean	agreed,
	boolean	personal,
	boolean	unhosted,
	String	beneficiary_vasp_name,
	String	beneficiary_vasp_did,
	String	beneficiary_vasp_website,
	String	beneficiary_first_name,
	String	beneficiary_last_name,
	String	beneficiary_company_name,
	String	beneficiary_address
)
{
}
