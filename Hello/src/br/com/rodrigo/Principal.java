package br.com.rodrigo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.rodrigo.poo.Aluno;
import br.com.rodrigo.poo.Carro;
import br.com.rodrigo.conta.ContaBancaria;
import br.com.rodrigo.exception.*;
import br.com.rodrigo.model.Pessoa;

public class Principal {
	
	public static void lerArquivo(String nome) throws FileNotFoundException  {
		//FileInputStream file = new FileInputStream(nome);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String complementoHelloWorld = "Hello World!";
		
		
		List<String> nomes = new ArrayList<>();
		
		nomes.add("Rodrigo");
		nomes.add("Gabriela");
		nomes.add("Nelia");
		
		for(String nome : nomes) {
			System.out.println("- " + nome);
		}
		
		System.out.println("------------------------------");
		
		nomes.add("Fulano");
		
		for(String nome : nomes) {
			System.out.println("- " + nome);
		}
		
		System.out.println("------------------------------");
		
		nomes.remove(3);
				
		for(String nome : nomes) {
			System.out.println("- " + nome);
		}
		
		System.out.println("------------------------------");
		
		System.out.println(nomes.get(0));
		
		System.out.println("------------------------------");
		
		//looping por iterator
		Iterator<String> it = nomes.iterator();
		
		while(it.hasNext()) {
			String nome1 = it.next();
			System.out.println(nome1);
		}
		
		System.out.println("------------------------------");
		
		Collections.sort(nomes);
		it = nomes.iterator();
		while(it.hasNext()) {
			String nome1 = it.next();
			System.out.println(nome1);
		}
		
		System.out.println("------------------------------");
		
		Pessoa p1 = new Pessoa(1, "Nome 1", "email1");
		List<Pessoa> pessoas = new ArrayList<>();
		
		pessoas.add(p1);
		
		for(Pessoa pessoa: pessoas) {		
		System.out.println("- " + pessoas.toString());
		}
		
		List<Pessoa> nomesFiltrados = pessoas.stream()
				.filter(pessoa -> "Rodrigo".contains(pessoa.getNome()))
				.collect(Collectors.toList());
		
		nomesFiltrados.forEach(System.out::println);
		
		Set<String> alunos = new HashSet<String>();
		alunos.add("Rodrigo");
		alunos.add("Gabriela");
		alunos.add("Nelia");
		alunos.add("Rodrigo"); //Não vai ser inserido
		alunos.forEach(System.out::println);
		
		System.out.println("------------------------------");
		
		Map<String, String> paises = new HashMap<>();
		paises.put("Brasil", "Brasilia");
		
		//iteracao
		for(Map.Entry<String, String> entry : paises.entrySet()) {
			System.out.println("# " + entry.getKey() + " | " + entry.getValue());
		}
		
		System.out.println("------------------------------");
		
		System.out.println(paises.get("Brasil"));
		
		System.out.println("------------------------------");
		
		if(paises.containsKey("Brasil"))
			System.out.println(paises.get("Brasil"));
		else
			System.out.println("Não tem o pais Brasil!");

		System.out.println("------------------------------");

		for(String pais : paises.keySet()) {
			System.out.println("& " + pais + " | " + paises.get(pais));
		}
				
		
		/*
		System.out.println("Hello World " + complementoHelloWorld);
		
		System.out.println("------------------------------");
		
		try {
			int divisao = 10 / 0;
			int[] numeros = {1,2,3};
		}
		catch (ArithmeticException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		System.out.println("Saiu da divisão por 0");
		
		System.out.println("------------------------------");
		
		try {
			int[] numeros = {0,1,2};
			
			int valor1 = 0;
			
			for (int i = 0; i <= 2; i++)
				valor1 = numeros[i];
				int valor2 = 10 / valor1;
				System.out.println("Valor 2: " + valor2);
			
			
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		catch (ArithmeticException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		System.out.println("Continuou 1");
		
		System.out.println("------------------------------");
		
		try {
			lerArquivo("");
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		}
		System.out.println("Leu o arquivo");
		
		System.out.println("------------------------------");
		
		ContaBancaria conta = new ContaBancaria();
		try {
			conta.fazerSaque(1100.0);
		} catch (LimiteCreditoExcedidoException e) {
			System.out.println(e.getMessage());
			System.out.println("Quantia excedida: " + e.getQuantiaExcedida());
		}
		
		
		
		boolean condicao = true;
		
		if(condicao) {
			System.out.println("condição verdadeira");
		}
		else {
		System.out.println("Condição falsa");
		}
		
		System.out.println("------------------------------");
		
		int x = 5;
		
		if(x>5) {
			System.out.println("x > 5");
		}
		else if(x<5) {
			System.out.println("x < 5");
		}
		else{
			System.out.println("x == 5");
		}
		
		System.out.println("------------------------------");
		
		int z = 10;
		
		switch (z) {
		case 1: { System.out.println("z == 1"); break;}
		case 5: { System.out.println("z == 5"); break;}
		case 10: { System.out.println("z == 10"); break;}
		default:
			throw new IllegalArgumentException("Unexpected value: " + z);
		}
		
		System.out.println("------------------------------");
		
		Carro carro = new Carro("Prata", "Honda", "CR-V");
		System.out.println(carro.toString());
		
		System.out.println("------------------------------");			
		
		carro.setCor("Preto");
		System.out.println(carro.toString());
		
		System.out.println("------------------------------");
		
		//todos os carros serão azuis - Usando override de método
		Carro rodrigo = new Carro("Fiat", "Mobi");
		System.out.println(rodrigo.toString());
		
		System.out.println("------------------------------");
		/*aluno1.setNome("Fulano");
		aluno1.setEmail("fulano@indra.com");
		aluno1.setDtMatricula("08/02/2024");
		aluno1.setMatricula("0001");*/
		
		/*
		Aluno aluno1 = new Aluno("0001", "08/02/2024", "Fulano", "fulano@indra.com");
		System.out.println(aluno1.toString());
		System.out.println("------------------------------");
		
		Aluno aluno2 = new Aluno("0002", "08/02/2024", "Ciclano", "ciclano@indra.com", "(11) 98248-4456");
		System.out.println(aluno2.toString());		
		System.out.println("------------------------------");
		*/
		
	}
}