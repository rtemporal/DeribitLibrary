package temporal.deribit.params;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public record auth
(
	GrantType	grant_type,
	String	client_id,
	String	client_secret,
	String	refresh_token,
	Long	timestamp,
	String	signature,
	String	nonce,
	String	data,
	String	state,
	String	scope
)
{
	public auth(String	client_id, String	client_secret)
	{
		this
		(
				GrantType.client_credentials,
				client_id,
				client_secret,
				null,
				null,
				null,
				null,
				null,
				null,
				null
		);
	}

	public auth(String	client_id, long	timestamp, String	nonce, String	data, String	signature)
	{
		this
		(
			GrantType.client_signature,
			client_id,
			null,
			null,
			timestamp,
			signature,
			nonce,
			data,
			null,
			null
		);
	}

	public auth(String	refresh_token)
	{
		this
		(
			GrantType.refresh_token,
			null,
			null,
			refresh_token,
			null,
			null,
			null,
			null,
			null,
			null
		);
	}

	public enum GrantType
	{
		client_credentials,
		client_signature,
		refresh_token
	}

	public boolean	verify(PublicKey	publicKey)
	{
		byte[]	message = createMessage(timestamp, nonce, data);

		return verify(message, publicKey);
	}

	public boolean	verify(byte[]	data, PublicKey	publicKey)
	{
		try
		{
		    Signature	signature = Signature.getInstance("Ed25519");

		    signature.initVerify(publicKey);
		    signature.update(data);

		    return signature.verify(getSignatureAsByteArray());
		}
		catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException	e)
		{
			throw new RuntimeException(e);
		}		
	}

	private byte[]	getSignatureAsByteArray()
	{
		Decoder	decoder = Base64.getUrlDecoder();

		return decoder.decode(signature);
	}

	public static byte[]	createMessage(long	timestamp, String	nonce, String	data)
	{
		String	message = timestamp + "\n" + nonce + "\n" + data;

		return message.getBytes(StandardCharsets.UTF_8);
	}

	public static String	encodeSignature(byte[]	signatureAsByteArray)
	{
		//contains -, _
		Encoder	encoder = Base64.getUrlEncoder().withoutPadding();
	
		return encoder.encodeToString(signatureAsByteArray);
	}
}
