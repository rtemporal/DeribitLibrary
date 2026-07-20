package temporal.deribit.dto;

import java.io.Serializable;

public record MarketMakerProtectionStatus
(
	IndexName	index_name,
	long	frozen_until,
	String	mmp_group,
	Boolean	block_rfq
)
implements Serializable
{
}
