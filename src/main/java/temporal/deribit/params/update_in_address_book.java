package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record update_in_address_book
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	Type	type,
	String	address,
	String	beneficiary_vasp_name,
	String	beneficiary_vasp_did,
	String	beneficiary_vasp_website,
	String	beneficiary_first_name,
	String	beneficiary_last_name,
	String	beneficiary_company_name,
	String	beneficiary_address,
	boolean	agreed,
	boolean	personal,
	String	label
)
{
	public enum Type
	{
		transfer,
		withdrawal,
		deposit_source
	}
}
