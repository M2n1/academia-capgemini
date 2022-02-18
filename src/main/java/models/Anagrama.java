package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrama {

	static List<String> lista1 = new ArrayList<String>();
	int contadorAnagramas = 0;

	public void gerarSubStrings(String palavra) {
		String sub1;

		for (int i = 0; i < palavra.length(); i++) {
			for (int j = 0; j < palavra.length(); j++) {
				int limite = (palavra.length() - j);
				if (i < limite) {
					sub1 = palavra.substring(i, limite);
					lista1.add(sub1);
				}
			}
		}
		System.out.println(lista1);
		organizarSubstrings();
	}

	public void organizarSubstrings() {

		for (int i = 0; i < lista1.size(); i++) {
			for (int j = 1; j < lista1.size(); j++)
				if (i < j && i != j)
					if (j < lista1.size()) {
						String aux1 = lista1.get(i);
						String aux2 = lista1.get(j);
						if (compararAnagramas(aux1, aux2))
							contadorAnagramas++;
					}

		}
		System.out.println("Total de Anagramas: " + contadorAnagramas);
	}

	public boolean compararAnagramas(String aux1, String aux2) {

		if (aux1.length() == aux2.length()) {
			char[] char1 = aux1.toCharArray();
			char[] char2 = aux2.toCharArray();
			Arrays.sort(char1);
			Arrays.sort(char2);
			String str1 = new String(char1);
			String str2 = new String(char2);
			if (!(str1.contains(" ") || str2.contains(" ")) && str1.equalsIgnoreCase(str2)) {
				System.out.println("[" + str1 + " " + str2 + "]");
				return true;
			}
		}
		return false;
	}
}
