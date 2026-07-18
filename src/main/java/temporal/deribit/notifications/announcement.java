package temporal.deribit.notifications;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public record announcement
(
	int	id,
	String	title,
	String	body,
	long	publication_timestamp,
	boolean	important,
	boolean	confirmation,
	Integer	unread,
	Action	action
)
implements Serializable {
	public enum Action
	{
		@JsonProperty("new")
		_new,
		deleted
	}
}
