package br.com.rodrigo.App.Contatos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.rodrigo.App.Contatos.model.Pessoa;

public interface PessoaServiceInterface {
	//Salvar o pessoa
	Pessoa save(Pessoa pessoa);
	//Recuperar todas as pessoa
	List<Pessoa> getAll();
	//Recuperar 1 pessoa
	Optional<Pessoa> getById(Long id);	
	//Atualizar o pessoa
	Pessoa update(Pessoa pessoa);
	//Deletar a pessoa
	void delete(Long id);

}
