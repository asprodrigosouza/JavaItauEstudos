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

import br.com.rodrigo.App.Contatos.model.Contato;
import br.com.rodrigo.App.Contatos.model.Pessoa;
import br.com.rodrigo.App.Contatos.repository.ContatoRepository;
import br.com.rodrigo.App.Contatos.repository.PessoaRepository;
import br.com.rodrigo.App.Contatos.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/contatos") //http://localhost:8080/api/contatos
public class ContatoResource {
	
	private ContatoService contatoService;
	
	@Autowired
	public ContatoResource(ContatoService contatoService) {
		this.contatoService = contatoService;
	}

	@Operation(summary = "Salva contato de uma pessoa no banco de dados")
	@PostMapping
	public ResponseEntity<Contato> save(@RequestBody Contato contato){
		Contato newContato = contatoService.save(contato);
		if(newContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newContato);
	}
	
	@Operation(summary = "Retorna os dados de um contato por id")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Contato>> getById(@PathVariable Long id){
		Optional<Contato> contato = contatoService.getById(id);
		if(contato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(contato);
	}
	

	@Operation(summary = "Retorna todos os contatos de uma pessoa")
	@GetMapping("{id}/pessoas") //http://localhost:8080/api/contatos/1/pessoas
	public ResponseEntity<List<Contato>> getAllContatosByPessoa(@PathVariable Long id){
		List<Contato> contato = contatoService.getAllContatosByPessoa(id);
		if(contato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(contato);
	}
	
	@Operation(summary = "Atualiza dados do contato por id")
	@PutMapping
	public ResponseEntity<Contato> update(@RequestBody Contato contato){
		Contato upContato = contatoService.update(contato);
		if(upContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(upContato);
	}
	
	@Operation(summary = "Deleta o contato por id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		contatoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); //Status 204 para sucesso na exclusao
	}
}
