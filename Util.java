package Util;

import java.security.MessageDigest;

public class Util {
	public static String getHash( String input) {
		StringBuffer result = new StringBuffer();
		
		try {
			MessageDigest md = MessageDigest.getInstance( "SHA-256"); //Singleton 패턴(new 없이 getInstance로 유일한 생성자를 가져옴.
			md.update( input.getBytes() );
			byte bytes[] = md.digest();
			for (int i = 0; i < bytes.length; ++i) {
				result.append( Integer.toString( ( bytes[ i ] & 0xff ) + 
						                         0x100, 16 ).substring( 1 ) );      
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();  //Hash코드 리턴.
	} // Hash 함수 생성. 문자열을 넘겨주면 그 문자열을 기반으로한 Hash값(SHA-256)을 생성함. 
}
