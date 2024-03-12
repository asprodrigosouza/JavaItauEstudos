package br.com.rodrigo.App.Contatos.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigo.App.Contatos.dto.MalaDiretaDTO;
import br.com.rodrigo.App.Contatos.model.Contato;
import br.com.rodrigo.App.Contatos.model.Pessoa;
import br.com.rodrigo.App.Contatos.service.ContatoService;
import br.com.rodrigo.App.Contatos.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/pessoas") //http://localhost:8080/api/pessoas
public class PessoaResource {
	
	private PessoaService pessoaService;
	
	@Autowired
	public PessoaResource(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	@Operation(summary = "Salva pessoas no banco de dados")
	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){
		Pessoa newPessoa = pessoaService.save(pessoa);
		if(newPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newPessoa);		
	}
	
	@Operation(summary = "Busca todos os registros de pessoas cadastradas")
	@GetMapping
	public ResponseEntity<List<Pessoa>> getAllPessoas(){
		List<Pessoa> pessoas = pessoaService.getAll();
		if(pessoas == null)
			return ResponseEntity.notFound().build();
		if(pessoas.size() == 0)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pessoas);
	}
	
	@Operation(summary = "Busca registro de pessoa por id")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> getById(@PathVariable Long id){
		Optional<Pessoa> pessoa = pessoaService.getById(id);
		if(pessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pessoa);
	}
	
	@Operation(summary = "Atualiza dados da pessoa por id")
	@PutMapping
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa){
		Pessoa upPessoa = pessoaService.update(pessoa);
		if(upPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(upPessoa);
	}
	
	@Operation(summary = "Deleta pessoa por id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); //Status 204 para sucesso na exclusao
	}
	
	@Operation(summary = "Busca uma pessoa via mala direta")
	@GetMapping("/maladireta/{id}") //http://localhost:8081/api/pessoas/maladireta/{id}
	public ResponseEntity<Optional<MalaDiretaDTO>> getMalaDiretaById(@PathVariable Long id){
		Optional<MalaDiretaDTO> malaDireta =  pessoaService.getMalaDireta(id);
		
		if(!malaDireta.isPresent())
			return ResponseEntity.notFound().build();
		else
		{
			return ResponseEntity.ok(malaDireta);
		}
	}
	
}