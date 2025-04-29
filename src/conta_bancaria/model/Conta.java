package conta_bancaria.model;

import java.text.NumberFormat;

public class Conta {
	
	// Definindo os atributos da classe
	
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	
	// M�todo Constructor
	
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	
	// M�todos -> Get l� e retorna um valor e o Set altera o valor 
	//Caso algum valor n�o deveria ser visto � s� n�o criar um get para um objeto, e caso um objeto n�o possa ser alterado, nao criar um set para ele.

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
	// M�todos Banc�rios (opera��es)
	
	public boolean sacar(float valor) {
		if (this.saldo < valor) {
			System.out.println("\nSaldo Insuficiente!");
			return false;
		}
		this.setSaldo(this.saldo - valor );
		return true;
	}
	
	public void depositar(float valor) {
		this.saldo += valor;
	}
	
		
	
	// M�todo para visualiza��o
	
	public void visualizar() {
		
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		String tipo = "";
		
		switch(this.tipo) {
		case 1 -> tipo = "Conta Corrente";
		case 2 -> tipo = "Conta Poupan�a";
		default -> tipo = "Inv�lido!";
		}
		
		
		
		System.out.println("*****************************************");
		System.out.println("************ DADOS DA CONTA *************");
		System.out.println("*****************************************");
		System.out.println("N�mero da Conta: " + this.numero+"       ");
		System.out.println("N�mero da Ag�ncia: " + this.agencia+"    ");
		System.out.println("Tipo da Conta: " + tipo+"           ");
		System.out.println("T�tular da Conta: " + this.titular+"     ");
		System.out.println("Saldo da Conta: " + nfMoeda.format(this.saldo)+"         ");
		
	}
		
	

}
