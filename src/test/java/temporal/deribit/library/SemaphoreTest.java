package temporal.deribit.library;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SemaphoreTest
{
	@Test
	void test()
	{
		final long	PERIOD = 200L;
		final long	ONE_PERCENT_TOLERANCE = PERIOD / 100L;

		Semaphore	semaphore = new Semaphore(PERIOD + ONE_PERCENT_TOLERANCE);
		int	number_of_requests = 0;
		long	startTime = System.currentTimeMillis();

		for(int	i = 0; i != 15; i++)
		{
			semaphore.acquire();
			number_of_requests++;
			semaphore.release();
		}

		semaphore.acquire();

		long	endTime = System.currentTimeMillis();
		final	float	ONE_SECOND = 1000.0F;
		float	locked_time_in_seconds = (endTime - startTime) / ONE_SECOND;
		float	requests_per_second = number_of_requests / locked_time_in_seconds;
		final	float	LIMIT_RATE = 5.0F;

		assertTrue(requests_per_second < LIMIT_RATE);
	}
}
