package temporal.deribit.library;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.NamedParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Objects;

import temporal.deribit.params.auth;

public class DeribitKey
{
	public DeribitKey()
	{
		try
		{
			KeyPairGenerator	keyPairGenerator = KeyPairGenerator.getInstance("Ed25519");

			keyPairGenerator.initialize(NamedParameterSpec.ED25519, secureRandom);

			KeyPair	keyPair = keyPairGenerator.generateKeyPair();

			setPublicKey(keyPair.getPublic());
			setPrivateKey(keyPair.getPrivate());
		}
		catch(NoSuchAlgorithmException | InvalidAlgorithmParameterException	e)
		{
			throw new RuntimeException(e);
		}
	}

	public DeribitKey(String	client_id, String	public_key, String	private_key)
	{
		this.client_id = client_id;
		this.public_key = public_key;
		this.private_key = private_key;
	}

	public String getClient_id()
	{
		return client_id;
	}

	public void setClient_id(String client_id)
	{
		this.client_id = client_id;
	}

	public String getPublic_key()
	{
		return public_key;
	}

	public void setPublic_key(String public_key)
	{
		this.public_key = public_key;
	}

	public String getPrivate_key()
	{
		return private_key;
	}

	public void setPrivate_key(String private_key)
	{
		this.private_key = private_key;
	}

	public byte[]	getPublicKeyAsByteArray()
	{
		return Base64.getDecoder().decode(public_key);
	}

	public void	setPublicKeyAsByteArray(byte[]	publicKey)
	{
		this.public_key = Base64.getEncoder().encodeToString(publicKey);
	}

	public byte[]	getPrivateKeyAsByteArray()
	{
		return Base64.getDecoder().decode(private_key);
	}

	public void	setPrivateKeyAsByteArray(byte[]	privateKey)
	{
		this.private_key = Base64.getEncoder().encodeToString(privateKey);
	}

	public PublicKey	getPublicKey()
	{
		try
		{
		   X509EncodedKeySpec	spec = new X509EncodedKeySpec(getPublicKeyAsByteArray());
		   KeyFactory	keyFactory = KeyFactory.getInstance("Ed25519");

		   return keyFactory.generatePublic(spec);
		}
		catch (NoSuchAlgorithmException | InvalidKeySpecException	e)
		{
			throw new RuntimeException(e);
		}
	}

	public void	setPublicKey(PublicKey	publicKey)
	{
		setPublicKeyAsByteArray(publicKey.getEncoded());
	}

	public PrivateKey	getPrivateKey()
	{
		try
		{
		    PKCS8EncodedKeySpec	spec = new PKCS8EncodedKeySpec(getPrivateKeyAsByteArray());
			KeyFactory	keyFactory = KeyFactory.getInstance("Ed25519");

			return keyFactory.generatePrivate(spec);
		}
		catch (NoSuchAlgorithmException | InvalidKeySpecException	e)
		{
			throw new RuntimeException(e);
		}
	}

	public void	setPrivateKey(PrivateKey	privateKey)
	{
		setPrivateKeyAsByteArray(privateKey.getEncoded());
	}

	public String	getPublicKeyAsPrivacyEnhancedMail()
	{
		final String	HEADER = "-----BEGIN PUBLIC KEY-----";
		final String	FOOTER = "-----END PUBLIC KEY-----";
		Encoder	encoder = Base64.getMimeEncoder(64, System.lineSeparator().getBytes());
	    String	publicKeyAsMime = encoder.encodeToString(getPublicKeyAsByteArray());

	    return HEADER + System.lineSeparator() + publicKeyAsMime + System.lineSeparator() + FOOTER;
	}

	public void	setPublicKeyAsPrivacyEnhancedMail(String	publicKeyAsPEM)
	{
		this.public_key = publicKeyAsPEM
			.replace("-----BEGIN PUBLIC KEY-----", "")
			.replace("-----END PUBLIC KEY-----", "")
			.replaceAll("\\s", "");
	}
	
	public String	getPrivateKeyAsPrivacyEnhancedMail()
	{
		final String	HEADER = "-----BEGIN PRIVATE KEY-----";
		final String	FOOTER = "-----END PRIVATE KEY-----";
		//The Mime contains +, /
		Encoder	encoder = Base64.getMimeEncoder(64, System.lineSeparator().getBytes());
	    String	privateKeyAsMime = encoder.encodeToString(getPrivateKeyAsByteArray());

	    return HEADER + System.lineSeparator() + privateKeyAsMime + System.lineSeparator() + FOOTER;
	}

	public void	setPrivateKeyAsPrivacyEnhancedMail(String	privateKeyAsPEM)
	{
		this.private_key = privateKeyAsPEM
			.replace("-----BEGIN PRIVATE KEY-----", "")
			.replace("-----END PRIVATE KEY-----", "")
			.replaceAll("\\s", "");
	}

	public auth	sign(String	data)
	{
		long	timestamp = System.currentTimeMillis();
		String	nonce = generateNonce();
		byte[]	message = auth.createMessage(timestamp, nonce, data);
	    byte[]	signatureAsByteArray = sign(message);
		String	signature = auth.encodeSignature(signatureAsByteArray);

	    return new auth(client_id, timestamp, nonce, data, signature);
	}

	private byte[]	sign(byte[]	data)
	{
		try
		{
		    Signature	signature = Signature.getInstance("Ed25519");
			
		    signature.initSign(getPrivateKey());
		    signature.update(data);
	
		    return signature.sign();
		}
		catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException	e)
		{
			throw new RuntimeException(e);
		}		
	}

	public int hashCode()
	{
		return Objects.hash(client_id, private_key, public_key);
	}

	public boolean	equals(Object	object)
	{
		if (this == object)
			return true;

		if (object == null)
			return false;

		if (getClass() != object.getClass())
			return false;

		DeribitKey	other = (DeribitKey) object;

		return Objects.equals(client_id, other.client_id) && Objects.equals(private_key, other.private_key)
				&& Objects.equals(public_key, other.public_key);
	}

	public String	toString()
	{
		StringBuffer	stringBuffer = new StringBuffer(DeribitKey.class.getSimpleName());

		stringBuffer.append(" [");
		stringBuffer.append("client_id=").append(client_id).append(", ");
		stringBuffer.append("public_key=").append(public_key).append(", ");
		stringBuffer.append("private_key=").append(private_key);
		stringBuffer.append("]");

		return stringBuffer.toString();
	}

	private static String	generateNonce()
	{
		final short	LENGTH = 8;
		byte[]	bytes = new byte[LENGTH];
		Encoder	encoder = Base64.getEncoder();

		secureRandom.nextBytes(bytes);

	    return encoder.encodeToString(bytes).substring(0, LENGTH);
	}

	private String	client_id;
	private String	public_key;
	private String	private_key;
	private static SecureRandom	secureRandom = new SecureRandom();
}
