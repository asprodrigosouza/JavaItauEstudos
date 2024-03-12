package br.com.rodrigo.App.Contatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodrigo.App.Contatos.dto.MalaDiretaDTO;
import br.com.rodrigo.App.Contatos.model.Pessoa;
import br.com.rodrigo.App.Contatos.repository.PessoaRepository;
import br.com.rodrigo.App.Contatos.service.interfaces.PessoaServiceInterface;

@Service
public class PessoaService implements PessoaServiceInterface {
	
	private PessoaRepository pessoaRepository;
	
	@Autowired
	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	
	@Override
	public Pessoa save(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@Override
	public List<Pessoa> getAll() {
		return pessoaRepository.findAll();
	}
	
	@Override
	public Optional<Pessoa> getById(Long id) {
		return pessoaRepository.findById(id);
	}
	
	@Override
	public Pessoa update(Pessoa pessoa) {
		//Encontra a pessoa pelo id
		Optional<Pessoa> findPessoa = pessoaRepository.findById(pessoa.getId());
		
		if(findPessoa.isPresent()) {
			Pessoa updatePessoa = findPessoa.get();
			updatePessoa.setNome(pessoa.getNome());
			updatePessoa.setEndereco(pessoa.getEndereco());
			updatePessoa.setCep(pessoa.getCep());
			updatePessoa.setCidade(pessoa.getCidade());
			updatePessoa.setUf(pessoa.getUf());
			return pessoaRepository.save(updatePessoa);
		}
		return pessoa;
	}
	
	@Override
	public void delete(Long id) {
		pessoaRepository.deleteById(id);
	}
	
	public Optional<MalaDiretaDTO> getMalaDireta(Long id) {
		
		if(this.pessoaRepository.findById(id).isPresent())
		{
			Optional<Pessoa> pessoa = pessoaRepository.findMalaDireta(id);
		
			if(pessoa.isPresent())
			{
				MalaDiretaDTO malaDiretaDTO = new MalaDiretaDTO(pessoa.get());
				return Optional.ofNullable(malaDiretaDTO);
			}
		}
		return null;
	}
}