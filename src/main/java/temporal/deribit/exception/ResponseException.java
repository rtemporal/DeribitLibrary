package temporal.deribit.exception;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;

import temporal.deribit.dto.Response;
import temporal.deribit.dto.Response.Error;
import temporal.deribit.params.Request;

@SuppressWarnings("serial")
public class ResponseException extends ExecutionException
{
	protected ResponseException()
	{
	}

	public String	getMessage()
	{
		return error.message();
	}

	public Error getError()
	{
		return error;
	}

	public Request<?> getRequest()
	{
		return request;
	}

	public static void	check(Request<?>	request, Response<?>	response) throws ResponseException
	{
		Error	error = response.error();

		if (error == null)
			return;

		ResponseException	result;

		try
		{
			Class<?>	cls = Class.forName("temporal.deribit.exception." + error.message());

			result = (ResponseException) cls.getDeclaredConstructor().newInstance();
		}
		catch (ClassNotFoundException | NoSuchMethodException | InstantiationException
		       | IllegalAccessException | InvocationTargetException e)
		{
			result = new ResponseException();
		}

		result.error = error;
		result.request = request;
		throw result;
	}

	private Error	error;
	private Request<?>	request;
}
