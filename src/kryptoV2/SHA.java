package kryptoV2;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA {

	String SHA1hex_create(String s)
	{
		return DigestUtils.sha1Hex(s);

	}
	String SHA256hex_create(String s)
	{
		return DigestUtils.sha256Hex(s);

	}
	String SHA384hex_create(String s)
	{
		return DigestUtils.sha384Hex(s);

	}
	String SHA512hex_create(String s)
	{
		return DigestUtils.sha512Hex(s);
		
	}
	
}
