package temporal.deribit.dto;

import java.io.Serializable;

public record Announcement
(
	String	body,
	long	publication_timestamp,
	int	id,
	boolean	important,
	String	title,
	Boolean	confirmation
)
implements Serializable {
}
