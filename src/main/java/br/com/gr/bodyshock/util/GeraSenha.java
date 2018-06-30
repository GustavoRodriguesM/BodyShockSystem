package br.com.gr.bodyshock.util;

import org.springframework.stereotype.Component;

@Component
public class GeraSenha {

	public static String getAlphanumericPassword(int digits) {

		String codigo = "";
		while (codigo.length() < digits) {
			int num = (int) (Math.random() * 122);
			if (num >= 48 && num <= 57)
				codigo += (char) num;
			else if (num >= 97 && num <= 122)
				codigo += (char) num;
			else if (num < 97)
				num = (int) (Math.random() * 122);
		}
		return codigo;
	}

}
