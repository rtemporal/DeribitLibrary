package temporal.deribit.library;

public class Semaphore
{
	public Semaphore(long	PERIOD)
	{
		this.PERIOD = PERIOD;
	}

	public synchronized void	acquire()
	{
		long	currentTime = System.currentTimeMillis();
		long	waitTime = unlockTime - currentTime;

		while(Long.signum(waitTime) == 1)
		{
			try
			{
				Thread.sleep(waitTime);
			}
			catch(InterruptedException	e)
			{
				e.printStackTrace();
			}
	
			currentTime = System.currentTimeMillis();
			waitTime = unlockTime - currentTime;
		}

		unlockTime = currentTime + PERIOD;
	}

	public synchronized void	release()
	{
		long	currentTime = System.currentTimeMillis();
		long	newUnlockTime = currentTime + PERIOD;

		if (unlockTime < newUnlockTime)
			unlockTime = newUnlockTime;
	}

	private long	unlockTime;
	private final long	PERIOD;
}
