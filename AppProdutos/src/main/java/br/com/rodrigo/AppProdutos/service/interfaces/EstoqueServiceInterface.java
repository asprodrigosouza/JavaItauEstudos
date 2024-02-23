package br.com.rodrigo.AppProdutos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.rodrigo.AppProdutos.model.Estoque;

public interface EstoqueServiceInterface {
	//Salvar produto
		Estoque save(Estoque estoque);
		
		//Recuperar um produto
		Optional<Estoque> getById(Long id);
		
		//Recuperar todos os produtos
		List<Estoque> getAll();
		
		//Atualizar produto
		Estoque update(Estoque estoque);
		
		//Deletar produto
		void delete(Estoque estoque);
}
