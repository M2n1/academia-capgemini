package models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnagramaTest {

	@Test
	public void deveRetornarNumeroAnagramas() {
		Anagrama anagrama = new Anagrama();
		anagrama.gerarSubStrings("ovo");
		int anagramas = anagrama.getContadorAnagramas();
		int expected = 2;

		assertEquals(expected, anagramas);
	}

}
