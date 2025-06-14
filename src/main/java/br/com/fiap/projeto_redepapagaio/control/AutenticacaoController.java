package br.com.fiap.projeto_redepapagaio.control;

import br.com.fiap.projeto_redepapagaio.dto.UsuarioDTO;
import br.com.fiap.projeto_redepapagaio.model.Usuario;
import br.com.fiap.projeto_redepapagaio.security.JwtResponse;
import br.com.fiap.projeto_redepapagaio.service.UsuarioCachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.projeto_redepapagaio.security.JWTUtil;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UsuarioCachingService usuarioCachingService;

	@PostMapping("/login")
	public ResponseEntity<?> gerarTokenValido(@RequestParam String username, @RequestParam String password) {
		try {
			// Cria o token de autenticação
			var auth = new UsernamePasswordAuthenticationToken(username, password);
			authenticationManager.authenticate(auth);  // Autentica o usuário

			Usuario usuario = usuarioCachingService.findByEmail(username).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));


			// Gera o JWT para o usuário autenticado
			String jwt = jwtUtil.construirToken(username);

			// Retorna o JWT para o cliente
			return ResponseEntity.ok(new JwtResponse(jwt, usuario.getIdUsuario())); // Retorna apenas o token

		} catch (Exception e) {
			// Em caso de erro de autenticação, retorne uma mensagem adequada
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
		}
	}
}
