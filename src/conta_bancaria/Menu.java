package conta_bancaria;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		
		Scanner leia = new Scanner(System.in);
		
		ContaController contas = new ContaController();
		
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo = 0, limite;
		
		// Dados para teste
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Jo�o da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
		contas.cadastrar(cp1);
		
	
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
				
				System.out.println("Digite o n�mero da Ag�ncia: ");
				agencia = leia.nextInt();
				System.out.println("Digite o nome do Titular: ");
				leia.skip("\\R");
				titular = leia.nextLine();
				System.out.println("Digite o tipo da Conta (1 - C/C | 2 - C/P): ");
				tipo = leia.nextInt();
				System.out.println("Digite o saldo da Conta: ");
				saldo = leia.nextFloat();
				
				switch(tipo) {
				case 1 -> {
					System.out.println("Digite o limite da conta: ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do anivers�rio da conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				  }
				}
				keyPress();
				break;
			case 2:
				System.out.println("Listar todas as Contas\n\n");
				contas.listarTodas();				
                keyPress();
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por n�mero\n\n");
				System.out.println("Digite o n�mero da conta: ");
				numero = leia.nextInt();
				contas.procurarPorNumero(numero);
                keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");
				System.out.println("Digite o n�mero da conta: ");
				numero = leia.nextInt();
				
				Optional<Conta> conta = contas.buscarNaCollection(numero);
				if(conta.isPresent()) {
					System.out.println("Digite o n�mero da Ag�ncia: ");
					agencia = leia.nextInt();
					
					System.out.println("Digite o nome do Titular: ");
					leia.skip("\\R");
					titular = leia.nextLine();
					
					tipo = conta.get().getTipo();
					
					System.out.println("Digite o saldo da Conta: ");
					saldo = leia.nextFloat();
				
					switch(tipo) {	
				case 1 -> {
					System.out.println("Digite o limite da conta: ");
					limite = leia.nextFloat();
					contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do anivers�rio da conta: ");
					aniversario = leia.nextInt();
					contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
				  }	
				}
					
									
				} else 
					System.out.printf("\nA conta n�mero %d n�o existe!", numero);
				
				
				keyPress();
				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");
				System.out.println("Digite o n�mero da conta: ");
				numero = leia.nextInt();
				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println("Saque\n\n");
				keyPress();
				break;
			case 7:
				System.out.println("Dep�sito\n\n");
				keyPress();
				break;
			case 8:
				System.out.println("Transfer�ncia entre Contas\n\n");
				keyPress();
				break;
			default:
				System.out.println("\nOp��o Inv�lida!\n");
				keyPress();
				break;
		  }
				
		}
	}
		
		public static void sobre() {
			System.out.println("\n*********************************************************");
			System.out.println("Projeto Desenvolvido por: ");
			System.out.println("Luiza Gon�alves - luizae.goncalves@hotmail.com");
			System.out.println("github.com/luizaeg");
			System.out.println("*********************************************************");
		
	}
		
		public static void keyPress() {
			 
			try {
	 
				System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
				System.in.read();
	 
			} catch (IOException e) {
	 
				System.err.println("Ocorreu um erro ao tentar ler o teclado");
	 
			}
		}

}
