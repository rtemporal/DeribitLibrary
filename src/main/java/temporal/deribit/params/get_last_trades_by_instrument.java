package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record get_last_trades_by_instrument
(
	@JsonUnwrapped
	Authorization	authorization,
	String	instrument_name,
	Integer	start_seq,
	Integer	end_seq,
	Long	start_timestamp,
	Long	end_timestamp,
	Short	count,
	Sorting	sorting
)
{
}
