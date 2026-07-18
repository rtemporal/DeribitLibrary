package temporal.deribit.notifications;

public enum Interval
{
	ONE_SECOND("agg2"),
	ONE_HUNDRED_MILLISECONDS("100ms"),
	CONTINUOUSLY("raw");

	private Interval(String	id)
	{
		this.id = id;
	}

	public String toString()
	{
        return id;
    }

	private String	id;
}
