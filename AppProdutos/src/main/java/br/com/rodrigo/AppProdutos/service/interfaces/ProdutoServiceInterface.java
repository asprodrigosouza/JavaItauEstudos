package br.com.rodrigo.AppProdutos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.rodrigo.AppProdutos.dto.ProdutoDTO;
import br.com.rodrigo.AppProdutos.dto.ProdutoSimplesDTO;
import br.com.rodrigo.AppProdutos.model.Produto;

public interface ProdutoServiceInterface {
	
	//Salvar o produto
	Produto save(Produto produto);
	//Recuperar 1 produto
	Optional<Produto> getById(Long id);
	//Recuperar todos os produtos
	List<Produto> getAll();
	//Atualizar o produto
	Produto update(Produto produto);
	//Deletar o produto
	void delete(Long id);
	List<ProdutoDTO> findProdutosAndQuantidade();
	List<ProdutoSimplesDTO> findProdutoSimplesAndQuantidade();
}