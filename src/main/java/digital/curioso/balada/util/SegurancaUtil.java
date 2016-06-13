package digital.curioso.balada.util;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.enterprise.context.Dependent;

@Dependent
public class SegurancaUtil {

	public String segurancaCripto(String mensagem) {
		
		byte[] encrypted = null;
		
        try {
	    	
	        MessageDigest md = MessageDigest.getInstance("SHA-512");
	        md.update(mensagem.getBytes());        	
	    	
	        String exa = stringHexa(md.digest());
	        
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			byte[] mensagemByte = md.digest();
			
			byte[] chave = new byte[16];
			System.arraycopy(new BigInteger(exa, 16).toByteArray(), 1, chave, 0, 16);
		
	        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(chave, "AES"));
	        encrypted = cipher.doFinal(mensagemByte);
	        
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
        
        return stringHexa(encrypted);
	
	}
	
	public String encrypt(String mensagem, String keyParam) {
		
		byte[] encrypted = null;
		
        try {
	        
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			byte[] mensagemByte = mensagem.getBytes();
			
			byte[] chave = new byte[16];
			System.arraycopy(new BigInteger(keyParam, 16).toByteArray(), 1, chave, 0, 16);
		
	        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(chave, "AES"));
	        encrypted = cipher.doFinal(mensagemByte);
	        
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
        
        return stringHexa(encrypted);
	
	}
	
	public String decrypt(String mensagem, String keyParam) {
		
		byte[] decrypted = null;
		
        try {
	        
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			byte[] mensagemByte = mensagem.getBytes();
			
			byte[] chave = new byte[16];
			System.arraycopy(new BigInteger(keyParam, 16).toByteArray(), 1, chave, 0, 16);
		
	        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(chave, "AES"));
	        decrypted = cipher.doFinal(mensagemByte);
	        
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
        
        return stringHexa(decrypted);
	
	}	

	private static String stringHexa(byte[] bytes) {
	   StringBuilder s = new StringBuilder();
	   for (int i = 0; i < bytes.length; i++) {
	       int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
	       int parteBaixa = bytes[i] & 0xf;
	       if (parteAlta == 0) s.append('0');
	       s.append(Integer.toHexString(parteAlta | parteBaixa));
	   }
	   return s.toString();
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
