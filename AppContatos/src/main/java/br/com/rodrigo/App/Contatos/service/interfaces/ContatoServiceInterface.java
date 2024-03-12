package br.com.rodrigo.App.Contatos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.rodrigo.App.Contatos.model.Contato;
import br.com.rodrigo.App.Contatos.model.Pessoa;

public interface ContatoServiceInterface {
	//Salvar o contato
	Contato save(Contato contato);
	//Recuperar 1 contato
	Optional<Contato> getById(Long id);
	//	List<Contato> getAll();
	//Recuperar todos os contatos de uma pessoa
	List<Contato> getAllContatosByPessoa(Long id);
	//Atualizar o contato
	Contato update(Contato estoque);
	//Deletar um contato
	void delete(Long id);		
}