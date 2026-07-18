package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;
import temporal.deribit.dto.Currency;
import temporal.deribit.dto.Kind;

public record cancel_all_by_kind_or_type
(
	@JsonUnwrapped
	Authorization	authorization,
	Currency	currency,
	Kind	kind,
	Type	type,
	Boolean	detailed,
	Boolean	freeze_quotes
)
{
	public enum Type
	{
		all,
		limit,
		trigger_all,
		stop,
		take,
		trailing_stop
	}
}
