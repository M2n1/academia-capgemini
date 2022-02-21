package models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnagramaTest {

	@Test
	public void deveRetornarNumeroAnagramas() {
		Anagrama anagrama = new Anagrama();
		anagrama.gerarSubStrings("ifailuhkqq");
		int anagramas = anagrama.getContadorAnagramas();
		int expected = 3;

		assertEquals(expected, anagramas);
	}

}
