package app;

import java.util.Scanner;

import models.Anagrama;
import models.Escada;
import models.OAuth;

/**
 * @author Marcelo Motta
 *
 */
public class Application {

	public static void main(String[] args) {
		final String LINE_SEPARATOR = System.lineSeparator();
		Scanner sc = new Scanner(System.in);
		int menu = -1;

		while (menu != 0) {
			System.out.println(LINE_SEPARATOR + "===== MENU PRINCIPAL=====");
			System.out.println("[ 1 ] - Questão 01 - Gerador de Escada de Caracteres");
			System.out.println("[ 2 ] - Questão 02 - Testador de senha forte");
			System.out.println("[ 3 ] - Questão 03 - Contador de Anagramas");
			System.out.println("[ 0 ] - Sair");

			int opcao = sc.nextInt();

			switch (opcao) {
			case 0:
				menu = 0;
				break;
			case 1:
				do {
					System.out.print(LINE_SEPARATOR + "Informe o número de degraus para construir a escada: ");
					Integer op1 = sc.nextInt();
					Escada escada = new Escada(op1);
					escada.gerarEscada();
					System.out.println(LINE_SEPARATOR + "Continuar - [1] | Menu principal - [4]");
					menu = sc.nextInt();
				} while (menu == 1);
				break;
			case 2:
				do {
					System.out.print(LINE_SEPARATOR + "Informe a senha a ser verificada: ");
					String senha = sc.next();
					OAuth oAuth = new OAuth(senha);
					oAuth.validate();
					String msg = oAuth.getMensagem().toString();

					while (!msg.equals("")) {
						sc = new Scanner(System.in);
						System.out
								.print("\n🙁 Ohnn, a senha não atende aos critérios obrigatórios, informe novamente: ");
						senha = sc.nextLine();
						oAuth = new OAuth(senha);
						oAuth.validate();
						msg = oAuth.getMensagem().toString();

					}

					System.out.println("Continuar [2] | Voltar para o menu - [4]");
					menu = sc.nextInt();
				} while (menu == 2);
				break;
			case 3:
				do {
					System.out.print(
							LINE_SEPARATOR + "Informe uma palavra para localizar o número de anagramas existentes: ");
					String anagrama = sc.next();
					Anagrama anag = new Anagrama();
					anag.gerarSubStrings(anagrama);

					System.out.println(LINE_SEPARATOR + "Continuar? sim[3] | não[4]");
					menu = sc.nextInt();
				} while (menu == 3);
				break;
			default:
				System.out.println(LINE_SEPARATOR + "Opção inválida, escolha novamente!");
			}
		}
		System.out.println("Tome um bom café, até mais! ☕");
	}

}
