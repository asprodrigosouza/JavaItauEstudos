package br.com.rodrigo.AppProdutos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.rodrigo.AppProdutos.model.Produto;

public interface ProdutoServiceInterface {

	//Salvar produto
	Produto save(Produto produto);
	
	//Recuperar um produto
	Optional<Produto> getById(Long id);
	
	//Recuperar todos os produtos
	List<Produto> getAll();
	
	//Atualizar produto
	Produto update(Produto produto);
	
	//Deletar produto
	void delete(Long id);
	
	
}
