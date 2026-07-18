package temporal.deribit.dto;

import java.io.Serializable;

public record DepositAddress
(
	long	creation_timestamp,
	Currency	currency,
	String	address,
	Type	type,
	Status	status,
	boolean	agreed,
	boolean	personal,
	boolean	requires_confirmation,
	boolean	requires_confirmation_change,
	boolean	info_required
)
implements Serializable {
	public enum Type
	{
		deposit
	}

	public enum Status
	{
		admin_locked,
		waiting,
		confirmed,
		ready
	}
}
