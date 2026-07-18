package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record set_clearance_originator
(
	@JsonUnwrapped
	Authorization	authorization,
	DepositId	deposit_id,
	Originator	originator
)
{
	public record DepositId
	(
		String	currency,
		int	user_id,
		String	address,
		String	tx_hash
	)
	{
	}

	public record Originator
	(
		boolean	is_personal,
		String	company_name,
		String	first_name,
		String	last_name,
		String	address
	)
	{
	}
}
