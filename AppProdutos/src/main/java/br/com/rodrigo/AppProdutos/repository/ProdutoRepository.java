package br.com.rodrigo.AppProdutos.repository;

import org.springframework.stereotype.Repository;
import br.com.rodrigo.AppProdutos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
}