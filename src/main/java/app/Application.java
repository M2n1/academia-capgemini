package app;

import models.Escada;

/**
 * @author Marcelo Motta
 *
 */
public class Application {

	public static void main(String[] args) {
		Escada escada = new Escada(6);
		escada.gerarEscada();
	}

}
