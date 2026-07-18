package temporal.deribit.notifications;

import temporal.deribit.dto.IndexName;
import java.io.Serializable;

public record user_mmp_trigger
(
	long	frozen_until,
	IndexName	index_name,
	String	mmp_group,
	boolean	block_rfq
)
implements Serializable {
}
