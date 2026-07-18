package temporal.deribit.library;

public enum Keyring
{
	library1MainAccount("1NxGIi8P"),
	library1SubAccount("w5MAh5DJ"),
	library2MainAccount("DUCFgN2p"),
	library2SubAccount("G4Re_sTW");

	public DeribitKey	deribitKey;

	private Keyring(String	client_id)
	{
		this.deribitKey = new DeribitKey(client_id, TEST_PUBLIC_KEY, TEST_PRIVATE_KEY);
	}

	private static final String	TEST_PUBLIC_KEY = "MCowBQYDK2VwAyEACxTcmwciFfW6fPVYUHCKhufevkLTLBkCog2sbVun/EE=";
	private static final String	TEST_PRIVATE_KEY = "MC4CAQAwBQYDK2VwBCIEIA94AICmia54L6XoyVlBU0HjyhMzYHVzj3q68dbRxcW8";
}
