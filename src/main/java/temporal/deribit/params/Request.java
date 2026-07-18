package temporal.deribit.params;

public record Request<T>(int	id, String	jsonrpc, String	method, T	params)
{
	public Request(String	method, T	params)
	{
		this(++number_generator, "2.0", method, params);
	}

	private static int	number_generator;
}
