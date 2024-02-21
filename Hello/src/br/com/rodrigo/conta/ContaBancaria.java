package br.com.rodrigo.conta;

import br.com.rodrigo.exception.LimiteCreditoExcedidoException;

public class ContaBancaria {
	public void fazerSaque(double quantia) throws LimiteCreditoExcedidoException {
		double limite = 1000.0; //Exemplo de limite
		if(quantia > limite)
			throw new LimiteCreditoExcedidoException(quantia - limite);
		else
			System.out.println("Saque realizado com sucesso!");		
	}
}