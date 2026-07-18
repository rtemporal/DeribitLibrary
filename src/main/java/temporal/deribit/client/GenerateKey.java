package temporal.deribit.client;

import temporal.deribit.library.DeribitKey;

public class GenerateKey
{
	public static void main(String[]	args)
	{
		DeribitKey	keyPair = new DeribitKey();

		System.out.println(keyPair.getPublicKeyAsPrivacyEnhancedMail());
		System.out.println(keyPair.getPrivateKeyAsPrivacyEnhancedMail());
	}
}
