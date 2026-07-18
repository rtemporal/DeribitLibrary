package temporal.deribit.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import temporal.deribit.dto.Currency;
import temporal.deribit.dto.IndexName;
import temporal.deribit.dto.Kind;
import temporal.deribit.dto.Order;
import temporal.deribit.dto.Trade;
import temporal.deribit.notifications.Instrument_state;
import temporal.deribit.notifications.Interval;
import temporal.deribit.notifications.Notification;
import temporal.deribit.notifications.Notification.Params;
import temporal.deribit.notifications.OnClose;
import temporal.deribit.notifications.announcement;
import temporal.deribit.notifications.block_rfq_maker;
import temporal.deribit.notifications.block_rfq_maker_quotes;
import temporal.deribit.notifications.block_rfq_taker;
import temporal.deribit.notifications.block_rfq_trades;
import temporal.deribit.notifications.block_trade_confirmations;
import temporal.deribit.notifications.book;
import temporal.deribit.notifications.book.Depth;
import temporal.deribit.notifications.book.Group;
import temporal.deribit.notifications.chart_trades;
import temporal.deribit.notifications.chart_trades.Resolution;
import temporal.deribit.notifications.deribit_price_index;
import temporal.deribit.notifications.deribit_price_ranking;
import temporal.deribit.notifications.deribit_price_statistics;
import temporal.deribit.notifications.deribit_volatility_index;
import temporal.deribit.notifications.estimated_expiration_price;
import temporal.deribit.notifications.incremental_ticker;
import temporal.deribit.notifications.markprice_options;
import temporal.deribit.notifications.perpetual;
import temporal.deribit.notifications.platform_state;
import temporal.deribit.notifications.public_methods_state;
import temporal.deribit.notifications.quote;
import temporal.deribit.notifications.ticker;
import temporal.deribit.notifications.user_access_log;
import temporal.deribit.notifications.user_changes;
import temporal.deribit.notifications.user_lock;
import temporal.deribit.notifications.user_mmp_trigger;
import temporal.deribit.notifications.user_portfolio;
import tools.jackson.core.type.TypeReference;

public class Channel<T> implements ObservableValue<Params<T>>, Future<Params<T>>
{
	public Channel(String	id, TypeReference<Notification<T>>	typeReference)
	{
		this.id = id;
		this.typeReference = typeReference;
		listenerList = Collections.synchronizedList(new ArrayList<>(1));
	}

	@SuppressWarnings("unchecked")
	public void setNotification(Notification<?>	notification)
	{
		if (!id.equals(notification.params().channel()))
			throw new IllegalArgumentException();

		setData((Params<T>) notification.params());
	}

	protected synchronized void setData(Params<T>	data)
	{
		Params<T>	oldValue = this.data;
		this.data = data;
		notifyAll();

		for(ChangeListener<? super Params<T>>	listener : listenerList)
			listener.changed(this, oldValue, data);
	}

	public synchronized void setError(Throwable error)
	{
		this.error = error;
		notifyAll();
	}

	public Params<T>	getValue()
	{
		return data;
	}

	public void	addListener(InvalidationListener	listener)
	{
	}

	public void	removeListener(InvalidationListener	listener)
	{
	}

	public synchronized void	addListener(ChangeListener<? super Params<T>>	listener)
	{
		listenerList.add(listener);
	}

	public synchronized void removeListener(ChangeListener<? super Params<T>>	listener)
	{
		listenerList.remove(listener);
	}

	public String	getId()
	{
		return id;
	}

	public TypeReference<Notification<T>>	getTypeReference()
	{
		return typeReference;
	}

	public void clear()
	{
		data = null;
	}

	public static synchronized void	clearAll()
	{
		for(Channel<?>	channel : channelMap.values())
			channel.clear();
	}

	public boolean	cancel(boolean mayInterruptIfRunning)
	{
		throw new UnsupportedOperationException();
	}

	public boolean	isCancelled()
	{
		return false;
	}

	public boolean	isDone()
	{
		return data != null || error != null;
	}

	public synchronized Params<T>	get() throws InterruptedException, ExecutionException
	{
		while (data == null && error == null)
			wait();

		if (error != null)
			throw new ExecutionException(error);

		return data;
	}

	public synchronized Params<T>	get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException
	{
		if (!TimeUnit.MILLISECONDS.equals(unit))
			throw new UnsupportedOperationException();

		long	deadline = System.currentTimeMillis() + timeout;

		while (data == null && error == null)
		{
			long	remaining = deadline - System.currentTimeMillis();

			if (remaining <= 0)
				throw new TimeoutException();

			wait(remaining);
		}

		if (error != null)
			throw new ExecutionException(error);

		return data;
	}

	public static synchronized Channel<?>	get(String	id)
	{
		return channelMap.get(id);
	}

	/*
	 * Platform.
	 */
	public static synchronized Channel<platform_state>	get_platform_state()
	{
		String	id = "platform_state";
		@SuppressWarnings("unchecked")
		Channel<platform_state>	channel = (Channel<platform_state>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<platform_state>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<public_methods_state>	get_public_methods_state()
	{
		String	id = "platform_state.public_methods_state";
		@SuppressWarnings("unchecked")
		Channel<public_methods_state>	channel = (Channel<public_methods_state>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<public_methods_state>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	/*
	 * Announcements.
	 */
	public static synchronized Channel<announcement>	get_announcements()
	{
		String	id = "announcements";
		@SuppressWarnings("unchecked")
		Channel<announcement>	channel = (Channel<announcement>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<announcement>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	/*
	 * Order book.
	 */
	public static synchronized Channel<book>	get_book(String	instrument_name, Interval	interval)
	{
		String	id = "book." + instrument_name + "." + interval;
		@SuppressWarnings("unchecked")
		Channel<book>	channel = (Channel<book>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<book>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<book>	get_book(String	instrument_name, Group	group, Depth	depth, Interval	interval)
	{
		String	id = "book." + instrument_name + "." + group + "." + depth + "." + interval;
		@SuppressWarnings("unchecked")
		Channel<book>	channel = (Channel<book>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<book>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	/*
	 * Market Data.
	 */
	public static synchronized Channel<ticker>	get_ticker(String	instrument_name, Interval	interval)
	{
		String	id = "ticker." + instrument_name + "." + interval;
		@SuppressWarnings("unchecked")
		Channel<ticker>	channel = (Channel<ticker>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<ticker>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<incremental_ticker>	get_incremental_ticker(String	instrument_name)
	{
		String	id = "incremental_ticker." + instrument_name;
		@SuppressWarnings("unchecked")
		Channel<incremental_ticker>	channel = (Channel<incremental_ticker>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<incremental_ticker>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<perpetual>	get_perpetual(String	instrument_name, Interval	interval)
	{
		String	id = "perpetual." + instrument_name + "." + interval;
		@SuppressWarnings("unchecked")
		Channel<perpetual>	channel = (Channel<perpetual>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<perpetual>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<quote>	get_quote(String	instrument_name)
	{
		String	id = "quote." + instrument_name;
		@SuppressWarnings("unchecked")
		Channel<quote>	channel = (Channel<quote>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<quote>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<deribit_price_index>	get_deribit_price_index(IndexName	index_name)
	{
		String	id = "deribit_price_index." + index_name;
		@SuppressWarnings("unchecked")
		Channel<deribit_price_index>	channel = (Channel<deribit_price_index>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<deribit_price_index>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<deribit_price_ranking>	get_deribit_price_ranking(IndexName	index_name)
	{
		String	id = "deribit_price_ranking." + index_name;
		@SuppressWarnings("unchecked")
		Channel<deribit_price_ranking>	channel = (Channel<deribit_price_ranking>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<deribit_price_ranking>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<deribit_price_statistics>	get_deribit_price_statistics(IndexName	index_name)
	{
		String	id = "deribit_price_statistics." + index_name;
		@SuppressWarnings("unchecked")
		Channel<deribit_price_statistics>	channel = (Channel<deribit_price_statistics>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<deribit_price_statistics>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<deribit_volatility_index>	get_deribit_volatility_index(IndexName	index_name)
	{
		String	id = "deribit_volatility_index." + index_name;
		@SuppressWarnings("unchecked")
		Channel<deribit_volatility_index>	channel = (Channel<deribit_volatility_index>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<deribit_volatility_index>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<markprice_options[]>	get_markprice_options(IndexName	index_name)
	{
		String	id = "markprice.options." + index_name;
		@SuppressWarnings("unchecked")
		Channel<markprice_options[]>	channel = (Channel<markprice_options[]>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<markprice_options[]>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<estimated_expiration_price>	get_estimated_expiration_price(IndexName	index_name)
	{
		String	id = "estimated_expiration_price." + index_name;
		@SuppressWarnings("unchecked")
		Channel<estimated_expiration_price>	channel = (Channel<estimated_expiration_price>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<estimated_expiration_price>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<chart_trades>	get_chart_trades(String	instrument_name, Resolution	resolution)
	{
		String	id = "chart.trades." + instrument_name + "." + resolution;
		@SuppressWarnings("unchecked")
		Channel<chart_trades>	channel = (Channel<chart_trades>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<chart_trades>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<Instrument_state>	get_instrument_state(Kind	kind, Currency	currency)
	{
		String	id = "instrument.state." + kind + "." + currency.toString().toLowerCase();
		@SuppressWarnings("unchecked")
		Channel<Instrument_state>	channel = (Channel<Instrument_state>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<Instrument_state>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	/*
	 * Trades.
	 */
	public static synchronized Channel<Trade>	get_trades(String	instrument_name, Interval	interval)
	{
		String	id = "trades." + instrument_name + "." + interval;
		@SuppressWarnings("unchecked")
		Channel<Trade>	channel = (Channel<Trade>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<Trade>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<Trade>	get_trades(Kind	kind, Currency	currency, Interval	interval)
	{
		String	id = "trades." + kind + "." + currency.toString().toLowerCase() + "." + interval;
		@SuppressWarnings("unchecked")
		Channel<Trade>	channel = (Channel<Trade>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<Trade>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	/*
	 * Block Trade.
	 */
	public static synchronized Channel<block_trade_confirmations>	get_block_trade_confirmations()
	{
		String	id = "block_trade_confirmations";
		@SuppressWarnings("unchecked")
		Channel<block_trade_confirmations>	channel = (Channel<block_trade_confirmations>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<block_trade_confirmations>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<block_trade_confirmations>	get_block_trade_confirmations(Currency	currency)
	{
		String	id = "block_trade_confirmations." + currency.toString().toLowerCase();
		@SuppressWarnings("unchecked")
		Channel<block_trade_confirmations>	channel = (Channel<block_trade_confirmations>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<block_trade_confirmations>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	/*
	 * User.
	 */
	public static synchronized Channel<user_mmp_trigger>	get_user_mmp_trigger(IndexName	index_name)
	{
		String	id = "user.mmp_trigger." + index_name;
		@SuppressWarnings("unchecked")
		Channel<user_mmp_trigger>	channel = (Channel<user_mmp_trigger>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<user_mmp_trigger>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<user_portfolio>	get_user_portfolio(Currency	currency)
	{
		String	id = "user.portfolio." + currency.toString().toLowerCase();
		@SuppressWarnings("unchecked")
		Channel<user_portfolio>	channel = (Channel<user_portfolio>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<user_portfolio>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<Trade>	get_user_trades(String	instrument_name, Interval	interval)
	{
		String	id = "user.trades." + instrument_name + "." + interval;
		@SuppressWarnings("unchecked")
		Channel<Trade>	channel = (Channel<Trade>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<Trade>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<Trade>	get_user_trades(Kind	kind, Currency	currency, Interval	interval)
	{
		String	id = "user.trades." + kind + "." + currency.toString().toLowerCase() + "." + interval;
		@SuppressWarnings("unchecked")
		Channel<Trade>	channel = (Channel<Trade>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<Trade>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<Trade>	get_user_combo_trades(String	instrument_name, Interval	interval)
	{
		String	id = "user.combo_trades." + instrument_name + "." + interval;
		@SuppressWarnings("unchecked")
		Channel<Trade>	channel = (Channel<Trade>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<Trade>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<Trade>	get_user_combo_trades(Kind	kind, Currency	currency, Interval	interval)
	{
		String	id = "user.combo_trades." + kind + "." + currency.toString().toLowerCase() + "." + interval;
		@SuppressWarnings("unchecked")
		Channel<Trade>	channel = (Channel<Trade>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<Trade>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<Order>	get_user_orders(String	instrument_name, Interval	interval)
	{
		String	id = "user.orders." + instrument_name + "." + interval;
		@SuppressWarnings("unchecked")
		Channel<Order>	channel = (Channel<Order>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<Order>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<Order>	get_user_orders(Kind	kind, Currency	currency, Interval	interval)
	{
		String	id = "user.orders." + kind + "." + currency.toString().toLowerCase() + "." + interval;
		@SuppressWarnings("unchecked")
		Channel<Order>	channel = (Channel<Order>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<Order>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<user_changes>	get_user_changes(String	instrument_name, Interval	interval)
	{
		String	id = "user.changes." + instrument_name + "." + interval;
		@SuppressWarnings("unchecked")
		Channel<user_changes>	channel = (Channel<user_changes>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<user_changes>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<user_changes>	get_user_changes(Kind	kind, Currency	currency, Interval	interval)
	{
		String	id = "user.changes." + kind + "." + currency.toString().toLowerCase() + "." + interval;
		@SuppressWarnings("unchecked")
		Channel<user_changes>	channel = (Channel<user_changes>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<user_changes>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<user_access_log>	get_user_access_log()
	{
		String	id = "user.access_log";
		@SuppressWarnings("unchecked")
		Channel<user_access_log>	channel = (Channel<user_access_log>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<user_access_log>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<user_lock>	get_user_lock()
	{
		String	id = "user.user_lock";
		@SuppressWarnings("unchecked")
		Channel<user_lock>	channel = (Channel<user_lock>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<user_lock>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	/*
	 * Block Rfq.
	 */
	public static synchronized Channel<block_rfq_maker>	get_block_rfq_maker(Currency	currency)
	{
		String	id = "block_rfq.maker." + currency.toString().toLowerCase();
		@SuppressWarnings("unchecked")
		Channel<block_rfq_maker>	channel = (Channel<block_rfq_maker>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<block_rfq_maker>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<block_rfq_taker>	get_block_rfq_taker(Currency	currency)
	{
		String	id = "block_rfq.taker." + currency.toString().toLowerCase();
		@SuppressWarnings("unchecked")
		Channel<block_rfq_taker>	channel = (Channel<block_rfq_taker>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<block_rfq_taker>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<block_rfq_maker_quotes>	get_block_rfq_maker_quotes(Currency	currency)
	{
		String	id = "block_rfq.maker.quotes." + currency.toString().toLowerCase();
		@SuppressWarnings("unchecked")
		Channel<block_rfq_maker_quotes>	channel = (Channel<block_rfq_maker_quotes>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<block_rfq_maker_quotes>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	public static synchronized Channel<block_rfq_trades>	get_block_rfq_trades(Currency	currency)
	{
		String	id = "block_rfq.trades." + currency.toString().toLowerCase();
		@SuppressWarnings("unchecked")
		Channel<block_rfq_trades>	channel = (Channel<block_rfq_trades>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<block_rfq_trades>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	/*
	 * Internal.
	 */
	public static synchronized Channel<OnClose>	getOnClose()
	{
		String	id = ExchangeSocket.class.getSimpleName() + ".onClose";
		@SuppressWarnings("unchecked")
		Channel<OnClose>	channel = (Channel<OnClose>) channelMap.get(id);

		if (channel == null)
		{
			TypeReference<Notification<OnClose>>	type = new TypeReference<>() {};
	
			channel = new Channel<>(id, type);
			channelMap.put(id, channel);
		}

		return channel;
	}

	private String	id;
	private TypeReference<Notification<T>>	typeReference;
	private List<ChangeListener<? super Params<T>>>	listenerList;
	private Params<T>	data;
	private Throwable	error;
	private static Map<String,Channel<?>>	channelMap = new HashMap<>();
}
