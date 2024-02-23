package br.com.rodrigo.AppProdutos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.rodrigo.AppProdutos.model.Estoque;
import br.com.rodrigo.AppProdutos.repository.EstoqueRepository;
import br.com.rodrigo.AppProdutos.service.interfaces.EstoqueServiceInterface;

@Service
public class EstoqueService implements EstoqueServiceInterface{

	private EstoqueRepository estoqueRepository;

	@Autowired
	public EstoqueService(EstoqueRepository estoqueRepository) {
		this.estoqueRepository = estoqueRepository;
	}
	
	@Override
	public Estoque save(Estoque estoque) {
		// TODO Auto-generated method stub
		return estoqueRepository.save(estoque);
	}

	@Override
	public Optional<Estoque> getById(Long id) {
		// TODO Auto-generated method stub
		return estoqueRepository.findById(id);
	}

	@Override
	public List<Estoque> getAll() {
		// TODO Auto-generated method stub
		return estoqueRepository.findAll();
	}

	@Override
	public Estoque update(Estoque estoque) {
		Optional<Estoque> findProduto = estoqueRepository.findById(estoque.getId());
		
		if(findProduto.isPresent()) {
			Estoque updateEstoque = findProduto.get();
			updateEstoque.setProduto(estoque.getProduto());
			updateEstoque.setQuantidade(estoque.getQuantidade());
			return estoqueRepository.save(updateEstoque);
		}
		return estoque;
	}

	@Override
	public void delete(Estoque estoque) {
		estoqueRepository.deleteById(estoque.getId());
	}	
}
