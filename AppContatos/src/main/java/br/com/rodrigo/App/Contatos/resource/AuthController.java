package br.com.rodrigo.App.Contatos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigo.App.Contatos.configuration.JwtTokenUtil;

@RestController
public class AuthController {
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@GetMapping("/token") //http://localhost:8080/token?username=nome
	public ResponseEntity<?> createToken(@RequestParam String username){
		String token = jwtTokenUtil.createToken(username);
		return ResponseEntity.ok(token);
	}
}
