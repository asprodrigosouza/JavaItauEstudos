package br.com.rodrigo.AppProdutos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.rodrigo.AppProdutos.model.Estoque;

public interface EstoqueServiceInterface {
	
	Estoque save(Estoque estoque);
	Optional<Estoque> getById(Long id);
	List<Estoque> getAll();
	Estoque update(Estoque estoque);
	void delete(Long id);	
}
