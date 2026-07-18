package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;

public record list_address_beneficiaries
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	String	address,
	String	tag,
	Long	created_before,
	Long	created_after,
	Long	updated_before,
	Long	updated_after,
	Boolean	personal,
	Boolean	unhosted,
	String	beneficiary_vasp_name,
	String	beneficiary_vasp_did,
	String	beneficiary_vasp_website,
	Short	limit,
	String	continuation
)
{
}
