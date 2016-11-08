package persistence;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public abstract class SecurityUtil{
	//Start of SHA function
		public static String EncryptPassword(String password){
		System.out.println("Unencrypted Pass: " + password);
		
		MessageDigest messageDigest = null;
		String salt = "$uper$ecretLongSaltValue!!@#$%^*&^%%+%^&";
		try{
			messageDigest = MessageDigest.getInstance("SHA-512");
			messageDigest.update((password + salt).getBytes());
		} catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}
			String encryptedPass = (new BigInteger(messageDigest.digest())).toString(16);
			System.out.println("Encrypted Pass: " + encryptedPass);
			return encryptedPass;
		}
	//End of SHA function
}
