package temporal.deribit.dto;

import java.io.Serializable;

public record MarginModelChange
(
	MarginModelState	old_state,
	MarginModelState	new_state,
	Currency	currency
)
implements Serializable
{
}
