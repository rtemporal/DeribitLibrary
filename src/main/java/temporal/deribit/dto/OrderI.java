package temporal.deribit.dto;

import java.math.BigDecimal;

public interface OrderI
{
	public Direction	direction();
	public String	instrument_name();
	public BigDecimal	amount();
	public BigDecimal	price();
}
