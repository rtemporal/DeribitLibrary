package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record RewardEligibility
(
	Status	eligibility_status,
	BigDecimal	apr_sma7
)
implements Serializable
{
	public enum Status
	{
		 eligible,
		 partially_eligible,
		 non_eligible
	}
}
