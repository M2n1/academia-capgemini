package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class OAuthTest {

	private static final String LINE_SEPARTOR = System.lineSeparator();
	private OAuth oAuth;

	@Before
	public void setup() {
		this.oAuth = new OAuth("Ya3&ab1");
	}

	@Test
	public final void deveVerificarInstanciaCriada() {
		assertNotNull(this.oAuth);
	}

	@Test
	public final void deveValidarDoisDigitosNaSenha() {
		int matches = this.oAuth.validateDigit();
		int expected = 2;
		assertEquals(expected, matches);
	}

	@Test
	public final void deveValidarUmCaracterMaiusculo() {
		int matches = this.oAuth.validateUppercase();
		int expected = 1;
		assertEquals(expected, matches);
	}

	@Test
	public final void deveValidarCaracterMinusculo() {
		int matches = this.oAuth.validateLowercase();
		int expected = 3;
		assertEquals(expected, matches);
	}

	@Test
	public final void deveValidarUmCaracterEspecial() {
		int matches = this.oAuth.validateCharacter();
		int expected = 1;
		assertEquals(expected, matches);
	}

	@Test
	public final void deveValidarMinimoSeisCaracteres() {
		int matches = this.oAuth.validateCharacterLength();
		int expected = 6;
		assertEquals(expected, matches);
	}

}
