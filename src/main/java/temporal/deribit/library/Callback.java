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
import temporal.deribit.notifications.Heartbeat;
import temporal.deribit.notifications.Method;
import tools.jackson.core.type.TypeReference;

public class Callback<T> implements ObservableValue<T>, Future<T>
{
	public Callback(String	id, TypeReference<Method<T>>	typeReference)
	{
		this.id = id;
		this.typeReference = typeReference;
		listenerList = Collections.synchronizedList(new ArrayList<>(1));
	}

	@SuppressWarnings("unchecked")
	public void setMethod(Method<?>	method)
	{
		if (!id.equals(method.method()))
			throw new IllegalArgumentException();

		setData((T) method.params());
	}

	protected synchronized void setData(T	data)
	{
		T	oldValue = this.data;
		this.data = data;
		notifyAll();

		for(ChangeListener<? super T>	listener : listenerList)
			listener.changed(this, oldValue, data);
	}

	public T	getValue()
	{
		return data;
	}

	public void	addListener(InvalidationListener	listener)
	{
	}

	public void	removeListener(InvalidationListener	listener)
	{
	}

	public synchronized void	addListener(ChangeListener<? super T>	listener)
	{
		listenerList.add(listener);
	}

	public synchronized void removeListener(ChangeListener<? super T>	listener)
	{
		listenerList.remove(listener);
	}

	public String	getId()
	{
		return id;
	}

	public TypeReference<Method<T>>	getTypeReference()
	{
		return typeReference;
	}

	public void clear()
	{
		data = null;
	}

	public static synchronized void	clearAll()
	{
		for(Callback<?>	callback : callbackMap.values())
			callback.clear();
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

	public synchronized T	get() throws InterruptedException, ExecutionException
	{
		while (data == null && error == null)
			wait();

		if (error != null)
			throw new ExecutionException(error);

		return data;
	}

	public synchronized T	get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException
	{
		long	deadline = System.currentTimeMillis() + unit.toMillis(timeout);

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

	public static synchronized Callback<?>	get(String	id)
	{
		return callbackMap.get(id);
	}

	/*
	 * Methods.
	 */
	public static synchronized Callback<Heartbeat>	getHeartbeat()
	{
		String	id = "heartbeat";
		@SuppressWarnings("unchecked")
		Callback<Heartbeat>	callback = (Callback<Heartbeat>) callbackMap.get(id);

		if (callback == null)
		{
			TypeReference<Method<Heartbeat>>	type = new TypeReference<>() {};
	
			callback = new Callback<>(id, type);
			callbackMap.put(id, callback);
		}

		return callback;
	}

	public synchronized void	setError(Throwable	error)
	{
		this.error = error;
		notifyAll();
	}

	private String	id;
	private TypeReference<Method<T>>	typeReference;
	private List<ChangeListener<? super T>>	listenerList;
	private T	data;
	private Throwable	error;
	private static Map<String,Callback<?>>	callbackMap = new HashMap<>();
}
