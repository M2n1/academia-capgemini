package app;

import models.Anagrama;
import models.Escada;
import models.OAuth;

/**
 * @author Marcelo Motta
 *
 */
public class Application {

	public static void main(String[] args) {
		Escada escada = new Escada(6);
		escada.gerarEscada();

		OAuth oAuth = new OAuth("Ya3&aab");
		oAuth.validate();

		Anagrama anagrama = new Anagrama();
		anagrama.gerarSubStrings("ifailuhkqq");

	}

}
