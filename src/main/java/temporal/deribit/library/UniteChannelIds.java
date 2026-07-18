package temporal.deribit.library;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UniteChannelIds implements Future<List<String>>
{
	public UniteChannelIds(Future<List<List<String>>>	compositeFuture)
	{
		this.compositeFuture = compositeFuture;
	}

	public boolean cancel(boolean mayInterruptIfRunning)
	{
		return compositeFuture.cancel(mayInterruptIfRunning);
	}

	public boolean isCancelled()
	{
		return compositeFuture.isCancelled();
	}

	public boolean isDone()
	{
		return compositeFuture.isDone();
	}

	public List<String>	get() throws InterruptedException, ExecutionException
	{
		return unite(compositeFuture.get());
	}

	public List<String>	get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException
	{
		return unite(compositeFuture.get(timeout, unit));
	}

	private List<String>	unite(List<List<String>>	groupList)
	{
		List<String>	outputList = new ArrayList<>();

		for(List<String>	group : groupList)
			for(String	channelId : group)
				outputList.add(channelId);

		return outputList;
	}

	private Future<List<List<String>>>	compositeFuture;
}
