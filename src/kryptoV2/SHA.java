package kryptoV2;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA {

	public String SHA1hex_create(String s)
	{
		String sha1hex = DigestUtils.sha1Hex(s);
		
		return sha1hex;
		
	}
	public String SHA256hex_create(String s)
	{
		String sha256hex = DigestUtils.sha256Hex(s);
		
		return sha256hex;
		
	}
	public String SHA384hex_create(String s)
	{
		String sha384hex = DigestUtils.sha384Hex(s);
		
		return sha384hex;
		
	}
	public String SHA512hex_create(String s)
	{
		String sha512hex = DigestUtils.sha512Hex(s);
		
		return sha512hex;
		
	}
	
}
