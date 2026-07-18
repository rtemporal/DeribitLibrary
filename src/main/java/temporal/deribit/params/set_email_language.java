package temporal.deribit.params;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import temporal.deribit.dto.Authorization;

public record set_email_language
(
	@JsonUnwrapped
	Authorization	authorization,
	Language	language
)
{
	public enum Language
	{
		en,
		ko,
		zh,
		ja,
		ru
	}
}
