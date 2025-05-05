package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.Optional;

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
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
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
