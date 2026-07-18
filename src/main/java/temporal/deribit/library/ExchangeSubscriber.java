package temporal.deribit.library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

import temporal.deribit.dto.Authorization;
import temporal.deribit.params.private_subscribe;
import temporal.deribit.params.public_subscribe;
import temporal.deribit.params.unsubscribe;

public class ExchangeSubscriber
{
	public ExchangeSubscriber(ExchangeMessenger	exchangeMessenger)
	{
		this.exchangeMessenger = exchangeMessenger;
	}

	public Future<List<String>>	public_subscribe(Authorization authorization, List<String>	channelIds)
	{
		List<List<String>>	groups = groupBySizeLimit(channelIds);
		List<Future<List<String>>>	futureList = new ArrayList<>(groups.size());
	
		for(List<String>	group : groups)
		{
			public_subscribe	output = new public_subscribe(authorization, group);
			Future<List<String>>	result = exchangeMessenger.public_subscribe(output);

			futureList.add(result);
		}

		Future<List<List<String>>>	compositeFuture = new CompositeFuture<>(futureList);
		Future<List<String>> uniteChannelIds = new UniteChannelIds(compositeFuture);
	
		return uniteChannelIds;
	}

	public Future<List<String>>	public_unsubscribe(Authorization authorization, List<String>	channelIds)
	{
		List<List<String>>	groups = groupBySizeLimit(channelIds);
		List<Future<List<String>>>	futureList = new ArrayList<>(groups.size());
	
		for(List<String>	group : groups)
		{
			unsubscribe	params = new unsubscribe(authorization, group);
			Future<List<String>>	result = exchangeMessenger.public_unsubscribe(params);

			futureList.add(result);
		}

		Future<List<List<String>>>	compositeFuture = new CompositeFuture<>(futureList);	
		Future<List<String>> uniteChannelIds = new UniteChannelIds(compositeFuture);
		
		return uniteChannelIds;
	}
	
	public Future<List<String>>	private_subscribe(Authorization authorization, String label, List<String>	channelIds)
	{
		List<List<String>>	groups = groupBySizeLimit(channelIds);
		List<Future<List<String>>>	futureList = new ArrayList<>(groups.size());
	
		for(List<String>	group : groups)
		{
			private_subscribe	params = new private_subscribe(authorization, label, group);
			Future<List<String>>	result = exchangeMessenger.private_subscribe(params);

			futureList.add(result);
		}
	
		Future<List<List<String>>>	compositeFuture = new CompositeFuture<>(futureList);
		Future<List<String>> uniteChannelIds = new UniteChannelIds(compositeFuture);
		
		return uniteChannelIds;
	}

	public Future<List<String>>	private_unsubscribe(Authorization authorization, List<String>	channelIds)
	{
		List<List<String>>	groups = groupBySizeLimit(channelIds);
		List<Future<List<String>>>	futureList = new ArrayList<>(groups.size());
	
		for(List<String>	group : groups)
		{
			unsubscribe	params = new unsubscribe(authorization, group);
			Future<List<String>>	result = exchangeMessenger.private_unsubscribe(params);

			futureList.add(result);
		}
	
		Future<List<List<String>>>	compositeFuture = new CompositeFuture<>(futureList);
		Future<List<String>> uniteChannelIds = new UniteChannelIds(compositeFuture);
		
		return uniteChannelIds;
	}

	private List<List<String>>	groupBySizeLimit(List<String>	channelIds)
	{
		Iterator<String>	iterator = channelIds.iterator();
		List<List<String>>	outerList = new ArrayList<>(channelIds.size() / MAX_NUMBER_OF_CHANNELS + 1);

		while(iterator.hasNext())
		{
			List<String>	innerList = new ArrayList<>(MAX_NUMBER_OF_CHANNELS);

			for(int	i = 0; iterator.hasNext() && i != MAX_NUMBER_OF_CHANNELS; i++)
				innerList.add(iterator.next());

			outerList.add(innerList);
		}

		return outerList;
	}

	private ExchangeMessenger	exchangeMessenger;
	private static final int	MAX_NUMBER_OF_CHANNELS = 500;
}
