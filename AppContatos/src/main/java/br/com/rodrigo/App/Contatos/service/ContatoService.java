package br.com.rodrigo.App.Contatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodrigo.App.Contatos.model.Contato;
import br.com.rodrigo.App.Contatos.model.Pessoa;
import br.com.rodrigo.App.Contatos.repository.ContatoRepository;
import br.com.rodrigo.App.Contatos.repository.PessoaRepository;
import br.com.rodrigo.App.Contatos.service.interfaces.ContatoServiceInterface;

@Service
public class ContatoService implements ContatoServiceInterface{
	
	private ContatoRepository contatoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public ContatoService() {
	}
	
	@Autowired
	public ContatoService(ContatoRepository contatoRepository) {
		this.contatoRepository = contatoRepository;
	}
	
	@Override
	public Contato save(Contato contato) {

		if(contato.getPessoa().getId() != null) {
			Optional<Pessoa> findPessoa = pessoaRepository.findById(contato.getPessoa().getId());
			
				contato.setPessoa(findPessoa.get());
				return contatoRepository.save(contato);
			}		
		
		return null;
	}
	
	@Override
	public Optional<Contato> getById(Long id) {
		return contatoRepository.findById(id);
	}
	
	@Override
	public List<Contato> getAllContatosByPessoa(Long id) {
		Optional<Pessoa> findPessoa = pessoaRepository.findById(id);
		return contatoRepository.findAllContatoByPessoa(findPessoa);
	}
	
	@Override
	public Contato update(Contato contato) {
		//Encontra o contato pelo id
		Optional<Contato> findContato = contatoRepository.findById(contato.getId());
		
		if(findContato.isPresent()) {
			Contato updateContato = findContato.get();
			updateContato.setTipoContato(contato.getTipoContato());
			updateContato.setContato(contato.getContato());
			return contatoRepository.save(updateContato);
		}
		return contato;
	}
	
	@Override
    public void delete(Long id) {
        contatoRepository.deleteById(id);
    }
}
