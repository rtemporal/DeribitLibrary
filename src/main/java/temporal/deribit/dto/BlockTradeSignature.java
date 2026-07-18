package temporal.deribit.dto;

import java.io.Serializable;

public record BlockTradeSignature
(
	String	signature,
	long	nonce,
	long	timestamp
)
implements Serializable {
}
