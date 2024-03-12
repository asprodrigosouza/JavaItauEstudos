package br.com.rodrigo.App.Contatos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.rodrigo.App.Contatos.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	@Query(value = "SELECT p.id, p.nome, p.logradouro, p.cep, p.municipio, p.uf FROM pessoa p WHERE p.id = :id", nativeQuery = true)
	Optional<Pessoa> findMalaDireta(Long id);
}
