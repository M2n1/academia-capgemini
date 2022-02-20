package models;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class EscadaTest {

	private Escada escada;

	@Before
	public void setup() {
		escada = new Escada(6);
	}

	@Test
	public void deveTestarTamanhoAltura() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		this.escada.gerarEscada();
		String response = out.toString();

		assertEquals(6, response.lines().count());

	}

	@Test
	public void deveTestarTamanhoBase() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		this.escada.gerarEscada();
		String response = out.toString();

		String str = response.substring(35, 41);
		assertEquals(6, str.length());

	}

	@Test
	public void deveVerificarAusenciaDeEspacosNaUltimaLinha() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		this.escada.gerarEscada();
		String response = out.toString();

		String linha = response.substring(35, 41);

		assertEquals(false, linha.matches("[\\s]"));
	}

}
