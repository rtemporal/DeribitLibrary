package temporal.deribit.library;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import temporal.deribit.dto.Response;
import temporal.deribit.exception.ResponseException;
import temporal.deribit.params.Request;
import tools.jackson.core.type.TypeReference;

public class FutureResponse<T> implements Future<T>
{
	public FutureResponse(Request<?>	request, TypeReference<Response<T>>	typeReference)
	{
		this.request = request;
		this.typeReference = typeReference;
	}

	@SuppressWarnings("unchecked")
	public synchronized void	setResponse(Response<?>	response)
	{
		if (request.id() != response.id())
			throw new IllegalArgumentException();

		this.response = (Response<T>) response;
		notifyAll();
	}

	public synchronized void	setError(Throwable	error)
	{
		this.error = error;
		notifyAll();
	}

	public int getId()
	{
		return request.id();
	}

	public TypeReference<Response<T>>	getTypeReference()
	{
		return typeReference;
	}

	public boolean	cancel(boolean	mayInterruptIfRunning)
	{
		throw new UnsupportedOperationException();
	}

	public boolean	isCancelled()
	{
		return false;
	}

	public boolean	isDone()
	{
		return response != null || error != null;
	}

	public synchronized T	get() throws InterruptedException, ExecutionException
	{
		while (response == null && error == null)
			wait();

		if (error != null)
			throw new ExecutionException(error);

		ResponseException.check(request, response);

		return response.result();
	}

	public synchronized T	get(long	timeout, TimeUnit	unit) throws InterruptedException, ExecutionException, TimeoutException
	{
		if (!TimeUnit.MILLISECONDS.equals(unit))
			throw new UnsupportedOperationException();

		long	deadline = System.currentTimeMillis() + timeout;

		while (response == null && error == null)
		{
			long	remaining = deadline - System.currentTimeMillis();

			if (remaining <= 0)
				throw new TimeoutException();

			wait(remaining);
		}

		if (error != null)
			throw new ExecutionException(error);

		ResponseException.check(null, response);

		return response.result();
	}

	private Request<?>	request;
	private TypeReference<Response<T>>	typeReference;
	private Response<T>	response;
	private Throwable	error;
}
