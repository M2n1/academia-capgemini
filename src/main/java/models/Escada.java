package models;

public class Escada {

	private Integer tamanho;

	public Escada(Integer tamanho) {
		this.tamanho = tamanho;
	}

	public void gerarEscada() {
		StringBuilder escada = new StringBuilder();
		int degraus = this.tamanho;

		for (int i = 1; i <= degraus; i++) {
			int espaco = degraus - i;
			escada.append(" ".repeat(espaco) + "*".repeat(i) + "\n");
		}
		System.out.print(escada);
	}
}
