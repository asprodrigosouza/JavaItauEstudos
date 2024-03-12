package br.com.rodrigo.App.Contatos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigo.App.Contatos.model.Contato;
import br.com.rodrigo.App.Contatos.model.Pessoa;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{
	List<Contato> findAllContatoByPessoa(Optional<Pessoa> findPessoa);
}
