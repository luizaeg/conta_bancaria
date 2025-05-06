package conta_bancaria.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import java.util.List;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;
import conta_bancaria.util.Cores;

public class ContaController implements ContaRepository {
	
	//Criar a Collection ArrayList
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	
	// Vari�vel para controlar os n�meros das contas
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
	
	Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent())
			conta.get().visualizar();
		else
			System.out.printf("\nA Conta n�mero %d n�o foi encontada", numero);
	}

	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT+"A Conta foi criada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {
Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());
		
		if(buscaConta.isPresent()) {
		   listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
		System.out.printf("\nA Conta n�mero %d foi atualizada com sucesso!", conta.getNumero());
		} else
			System.out.printf("\nA Conta n�mero %d n�o foi encontada", conta.getNumero());
	
		
	}

	@Override
	public void deletar(int numero) {
Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent()) {
			if(listaContas.remove(conta.get()) == true)
			 System.out.printf("\nA conta n�mero %d foi exclu�da com sucesso!" , numero);
		} else
			System.out.printf("\nA Conta n�mero %d n�o foi encontada", numero);

	}
	
	
	@Override
	public void listarPorTitular(String titular) {
		
	List<Conta> listaTitulares = listaContas.stream()
				.filter(c -> c.getTitular().toUpperCase().contains(titular.toUpperCase()))
				.collect(Collectors.toList());
		if(listaTitulares.isEmpty())
			System.out.printf("\nNenhuma conta foi encontrada com base no crit�rio %s", titular);
		for (var conta : listaTitulares)
			conta.visualizar();
		
	}
	

	@Override
	public void sacar(int numero, float valor) {
	
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent()) {
			if(conta.get().sacar(valor) == true)
				System.out.printf("O saque no valor de %s foi efetuado com sucesso da conta n�mero %d", nfMoeda.format(valor), numero);
		} else
			System.out.printf("\nA Conta n�mero %d n�o foi encontada", numero);
		
	}

	@Override
	public void depositar(int numero, float valor) {
		
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
		Optional<Conta> conta = buscarNaCollection(numero);
				
				if(conta.isPresent()) {
				conta.get().depositar(valor); 
					System.out.printf("O dep�sito no valor de %s foi efetuado com sucesso na conta n�mero %d", nfMoeda.format(valor), numero);
				} else
					System.out.printf("\nA Conta n�mero %d n�o foi encontada", numero);
				
			}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
	
NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
		Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);
		
				if(contaOrigem.isPresent() && contaDestino.isPresent()) {
					if(contaOrigem.get().sacar(valor) == true) {
						contaDestino.get().depositar(valor);
					System.out.printf("A transfer�ncia no valor de %s da conta n�mero %d para a conta %d foi efetuado com sucesso!", nfMoeda.format(valor), numeroOrigem, numeroDestino);
				} else
					System.out.printf("\nA Conta n�mero %d n�o foi encontada", numero);
				}
		
		
	}
	
	// M�todos Auxiliares
	
	public int gerarNumero() {
		return ++ numero;
	}
	
	public Optional<Conta> buscarNaCollection(int numero) {
		for(var conta : listaContas) {
			if(conta.getNumero() == numero)
				return Optional.of(conta);
		}
		
		return Optional.empty();
		
	}

	

}
