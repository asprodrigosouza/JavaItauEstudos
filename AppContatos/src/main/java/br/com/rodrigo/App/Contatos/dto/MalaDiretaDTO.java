package br.com.rodrigo.App.Contatos.dto;

import br.com.rodrigo.App.Contatos.model.Pessoa;

public class MalaDiretaDTO {
	
	private Long id;
	private String nome;
	private String enderecoCompleto;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}
	public MalaDiretaDTO(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.enderecoCompleto = pessoa.getEndereco() + " - " 
				+ pessoa.getCep() + " - " + pessoa.getCidade() + "-" + pessoa.getUf();
	}

	public void setEnderecoCompleto(String endereco, String cep, String cidade, String uf) {
		this.enderecoCompleto = endereco + " - " + cep + " - " + cidade + "-" + uf;
	}
}