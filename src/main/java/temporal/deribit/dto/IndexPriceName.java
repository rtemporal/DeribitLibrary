package temporal.deribit.dto;

import java.io.Serializable;

public record IndexPriceName
(
	String	name,
	Boolean	future_combo_creation_enabled,
	Boolean	option_combo_creation_enabled
)
implements Serializable
{
	public IndexPriceName(String	name)
	{
		this(name, null, null);
	}
}
