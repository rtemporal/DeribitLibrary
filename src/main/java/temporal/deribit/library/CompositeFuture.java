package temporal.deribit.library;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompositeFuture<T> implements Future<List<T>>
{
	public CompositeFuture(List<Future<T>>	futureList)
	{
		this.futureList = futureList;
	}

	public boolean	cancel(boolean	mayInterruptIfRunning)
	{
		boolean	cancelled = true;

		for(Future<T>	future : futureList)
			cancelled &= future.cancel(mayInterruptIfRunning);

		return cancelled;
	}

	public boolean isCancelled()
	{
		boolean	cancelled = true;

		for(Future<T>	future : futureList)
			cancelled &= future.isCancelled();

		return cancelled;
	}

	public boolean isDone()
	{
		boolean	done = true;

		for(Future<T>	future : futureList)
			done &= future.isCancelled();

		return done;
	}

	public List<T>	get() throws InterruptedException, ExecutionException
	{
		List<T>	outputList = new ArrayList<>(futureList.size());

		for(Future<T>	future : futureList)
			outputList.add(future.get());

		return outputList;
	}

	public List<T>	get(long	timeout, TimeUnit	unit) throws InterruptedException, ExecutionException, TimeoutException
	{
		List<T>	outputList = new ArrayList<>(futureList.size());

		for(Future<T>	future : futureList)
			outputList.add(future.get(timeout, unit));

		return outputList;
	}

	private List<Future<T>>	futureList;
}
