package kryptoV2;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {

	
	public String md2hex_create (String s)
	{
		String md2hex =  DigestUtils.md2Hex(s);
		
		return md2hex;
		
	}
	
	public String md5hex_create (String s)
	{
		String md5hex =  DigestUtils.md5Hex(s);
		
		return md5hex;
		
	}
	
	
}
