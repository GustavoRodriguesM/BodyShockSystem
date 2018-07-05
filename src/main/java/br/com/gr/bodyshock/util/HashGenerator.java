package br.com.gr.bodyshock.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class HashGenerator {

	public static String md5(String senha) {
		String code = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
		code = hash.toString(16);
		return code;
	}

	public static String getAlphanumericPassword(int digits) {

		String code = "";
		while (code.length() < digits) {
			int num = (int) (Math.random() * 122);
			if (num >= 48 && num <= 57)
				code += (char) num;
			else if (num >= 97 && num <= 122)
				code += (char) num;
			else if (num < 97)
				num = (int) (Math.random() * 122);
		}
		return code;
	}

}
