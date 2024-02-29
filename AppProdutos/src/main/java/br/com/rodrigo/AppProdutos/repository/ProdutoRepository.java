package br.com.rodrigo.AppProdutos.repository;

import org.springframework.stereotype.Repository;
import br.com.rodrigo.AppProdutos.model.Produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query(value = "SELECT p.id, p.codigo_barras, p.nome, p.preco, e.quantidade FROM produto p INNER JOIN estoque e on p.id = e.produto_id ORDER BY e.quantidade DESC ", nativeQuery = true)
	List<Object[]> findProdutosAndQuantidade();
	
	@Query(value = "SELECT * FROM buscar_produtos_estoque()", nativeQuery = true)
	List<Object[]> findProdutosSimplesAndQuantidade(); //busca por procedimento
	
}