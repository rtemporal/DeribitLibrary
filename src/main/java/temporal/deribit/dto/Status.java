package temporal.deribit.dto;

import java.io.Serializable;

public record Status
(
	String	locked,
	String[]	locked_indices
)
implements Serializable {
}
