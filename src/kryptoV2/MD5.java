package kryptoV2;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {

	
	String md2hex_create (String s)
	{
		return DigestUtils.md2Hex(s);
		
	}
	
	String md5hex_create (String s)
	{
		return DigestUtils.md5Hex(s);
		
	}
	
	
}
