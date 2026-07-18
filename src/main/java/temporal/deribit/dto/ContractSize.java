package temporal.deribit.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record ContractSize(BigDecimal	contract_size)
implements Serializable {
}
