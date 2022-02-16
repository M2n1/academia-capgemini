package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OAuth {
	private static final String DIGIT = "[0-9]";
	private static final String UPPERCASE = "[A-Z]";
	private static final String LOWERCASE = "[a-z]";
	private static final String CHARACTER = "[!@#$%^&*()+-]";
	private static final String LENGTH = "[\\w]";

	private String senha;
	private StringBuilder mensagem = new StringBuilder();

	public OAuth(String senha) {
		this.senha = senha;
	}

	public int verify(String regex, String senha) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(senha);
		int count = 0;

		while (matcher.find()) {
			count++;
		}
		return count;

	}

	public void validate() {
		validateCharacterLength();
		validateDigit();
		validateLowercase();
		validateUppercase();
		validateCharacter();

		if (this.mensagem.toString().equals("")) {
			System.out.println("Senha cadastrada com sucesso!");
		} else
			System.out.println(this.mensagem);
	}

	private void validateCharacterLength() {
		int value = verify(LENGTH, senha);
		if (value < 6)
			this.mensagem.append("Senha deve ter no mínimo 6 caracteres.\n");
	}

	private void validateDigit() {
		int value = verify(DIGIT, senha);
		if (value == 0)
			this.mensagem.append("A senha deve conter no mínimo 1 digito.\n");
	}

	private void validateLowercase() {
		int value = verify(LOWERCASE, senha);
		if (value == 0)
			this.mensagem.append("A senha deve conter no mínimo 1 letra em minúsculo.\n");
	}

	private void validateUppercase() {
		int value = verify(UPPERCASE, senha);
		if (value == 0)
			this.mensagem.append("A senha deve conter no mínimo 1 letra em maiúsculo.\n");
	}

	private void validateCharacter() {
		int value = verify(CHARACTER, senha);
		if (value == 0)
			this.mensagem.append("A senha deve conter no mínimo 1 caractere especial: !@#$%^&*()-+\n");
	}
}
