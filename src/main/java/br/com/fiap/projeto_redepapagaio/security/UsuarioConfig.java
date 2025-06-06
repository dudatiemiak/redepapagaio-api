package br.com.fiap.projeto_redepapagaio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fiap.projeto_redepapagaio.model.Usuario;
import br.com.fiap.projeto_redepapagaio.repository.UsuarioRepository;

@Configuration
public class UsuarioConfig {

	@Autowired
	private UsuarioRepository repU;

	@Bean
	public UserDetailsService gerarUsuario() {

		return nmEmail -> {
			Usuario usuario = repU.findByNmEmail(nmEmail)
					.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado na base de dados"));

			// Corrigido para usar 'usuario' em vez de 'usuarioSistema'
			return User.builder()
					.username(usuario.getNmEmail())
					.password(usuario.getNmSenha())
					.roles("USER")
					.build();
		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// Substituído NoOpPasswordEncoder por BCryptPasswordEncoder
		return new BCryptPasswordEncoder();
	}
}
