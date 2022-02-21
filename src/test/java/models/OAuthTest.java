package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class OAuthTest {

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

	@Test
	public final void deveVerificarMensagemDeErroParaDigitos() {
		ByteArrayOutputStream outFake = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outFake));

		OAuth password = new OAuth("Ya&faab");
		password.validate();

		String messageExpected = "A senha deve conter no mínimo 1 digito.\n";

		assertEquals(messageExpected, password.getMensagem().toString());
	}

	@Test
	public final void deveVerificarMensagemDeErroParaTamanhoDaSenha() {
		ByteArrayOutputStream outFake = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outFake));

		OAuth password = new OAuth("Ya3&a");
		password.validate();

		String messageExpected = "Senha deve ter no mínimo 6 caracteres.\n";

		assertEquals(messageExpected, password.getMensagem().toString());
	}

	@Test
	public final void deveVerificarMensagemDeErroParaMinusculo() {
		ByteArrayOutputStream outFake = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outFake));

		OAuth password = new OAuth("Y3&B2IO");
		password.validate();

		String messageExpected = "A senha deve conter no mínimo 1 letra em minúsculo.\n";

		assertEquals(messageExpected, password.getMensagem().toString());
	}

	@Test
	public final void deveVerificarMensagemDeErroParaMaiusculo() {
		ByteArrayOutputStream outFake = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outFake));

		OAuth password = new OAuth("a3&aaba");
		password.validate();

		String messageExpected = "A senha deve conter no mínimo 1 letra em maiúsculo.\n";

		assertEquals(messageExpected, password.getMensagem().toString());
	}

	@Test
	public final void deveVerificarMensagemDeErroParaCaracterEspecial() {
		ByteArrayOutputStream outFake = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outFake));

		OAuth password = new OAuth("Ya3aabc");
		password.validate();

		String messageExpected = "A senha deve conter no mínimo 1 caractere especial: !@#$%^&*()-+\n";

		assertEquals(messageExpected, password.getMensagem().toString());
	}

	@Test
	public final void deveVerificarMensagemDeSenhaCadastradaComSucesso() {
		ByteArrayOutputStream outFake = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outFake));

		OAuth password = new OAuth("Ya3&aab");
		password.validate();

		String messageExpected = "";

		assertEquals(messageExpected, password.getMensagem().toString());
	}
}
