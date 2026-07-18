package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.IndexName;

public record reset_mmp
(
	@JsonUnwrapped
	Authorization	authorization,
	IndexName	index_name,
	String	mmp_group,
	Boolean	block_rfq
)
{
}
