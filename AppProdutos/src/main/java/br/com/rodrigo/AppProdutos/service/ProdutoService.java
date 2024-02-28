package br.com.rodrigo.AppProdutos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.rodrigo.AppProdutos.model.Produto;
import br.com.rodrigo.AppProdutos.repository.ProdutoRepository;
import br.com.rodrigo.AppProdutos.service.interfaces.ProdutoServiceInterface;

@Service
public class ProdutoService implements ProdutoServiceInterface {

	private ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@Override
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Override
	public Optional<Produto> getById(Long id) {
		return produtoRepository.findById(id);
	}

	@Override
	public List<Produto> getAll() {
		return produtoRepository.findAll();
	}

	@Override
	public Produto update(Produto produto) {
		Optional<Produto> findProduto = produtoRepository.findById(produto.getId());
		
		//se ele existir, vou atualizar:
		if(findProduto.isPresent()) {
			Produto updateProduto = findProduto.get(); //setId
			updateProduto.setCodigoBarras(produto.getCodigoBarras());
			updateProduto.setNome(produto.getNome());
			updateProduto.setPreco(produto.getPreco());
			return produtoRepository.save(updateProduto);
		}
		return produto;		
	}

	@Override
	public void delete(Long id) {
		produtoRepository.deleteById(id);		
	}
}