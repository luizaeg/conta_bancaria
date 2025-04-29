package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		
		Scanner leia = new Scanner(System.in);
		int opcao;
		
		Conta c1 = new Conta(1, 123, 1, "Luiza", 500000);
		
		c1.visualizar();
		c1.sacar(100);
		c1.visualizar();
		c1.depositar(1000);
		c1.visualizar();
		
		c1.setTitular("Luiza Gon�alves");
		c1.visualizar();
		
		// Instanciando um objeto da Classe ContaCorrente
		ContaCorrente cc1 = new ContaCorrente(2, 456, 1, "Renata Negrini", 600000, 60000);	
		cc1.visualizar();
		
		cc1.sacar(610000);
		cc1.visualizar();
		
		// Instanciando um objeto da Classe ContaPoupan�a
		ContaPoupanca cp1 = new ContaPoupanca(2, 999, 2, "Maria Silva", 1500, 15);
		cp1.visualizar();
		cp1.sacar(300);
		cp1.visualizar();
		cp1.depositar(80);
		cp1.visualizar();
		
		while (true) {
	
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+"                                                    ");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_CYAN_BOLD_BRIGHT+"            BANCO DO BRAZIL COM Z                   ");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+"                                                    ");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_CYAN_BOLD_BRIGHT+"****************************************************");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+"                                                    ");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+"                                                    ");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_CYAN_BOLD_BRIGHT+"             1 - Criar Conta                        ");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_CYAN_BOLD_BRIGHT+"             2 - Listar todas as Contas             ");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_CYAN_BOLD_BRIGHT+"             3 - Buscar Conta por n�mero            ");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_CYAN_BOLD_BRIGHT+"             4 - Atualizar Dados da Conta           ");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_CYAN_BOLD_BRIGHT+"             5 - Apagar Conta                       ");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_CYAN_BOLD_BRIGHT+"             6 - Sacar                              ");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_CYAN_BOLD_BRIGHT+"             7 - Depositar                          ");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_CYAN_BOLD_BRIGHT+"             8 - Transferir                         ");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_CYAN_BOLD_BRIGHT+"             9 - Sair                               ");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+"                                                    ");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_CYAN_BOLD_BRIGHT+"****************************************************");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+"                                                    ");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_CYAN_BOLD_BRIGHT+"    Entre com a op��o desejada:                     ");
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+"                                                    ");
		
		opcao = leia.nextInt();

		if (opcao == 9) {
			System.out.println("\nBanco do Brazil com Z - O seu Futuro come�a aqui!");
			sobre();
             leia.close();
			System.exit(0);
		}

		switch (opcao) {
			case 1:
				System.out.println("Criar Conta\n\n");

				break;
			case 2:
				System.out.println("Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println("Consultar dados da Conta - por n�mero\n\n");

				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println("Saque\n\n");

				break;
			case 7:
				System.out.println("Dep�sito\n\n");

				break;
			case 8:
				System.out.println("Transfer�ncia entre Contas\n\n");

				break;
			default:
				System.out.println("\nOp��o Inv�lida!\n");
				break;
		  }
				
		}
	}
		
		public static void sobre() {
			System.out.println("\n*********************************************************");
			System.out.println("Projeto Desenvolvido por: ");
			System.out.println("Generation Brasil - generation@generation.org");
			System.out.println("github.com/conteudoGeneration");
			System.out.println("*********************************************************");
		
	}

}
