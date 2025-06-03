package br.com.fiap.projeto_redepapagaio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fiap.projeto_redepapagaio.model.UsuarioSistema;
import br.com.fiap.projeto_redepapagaio.repository.UsuarioSistemaRepository;

@Configuration
public class UsuarioConfig {

	@Autowired
	private UsuarioSistemaRepository userRepository;

	@Bean
	UserDetailsService gerarUsuario() {

		return username -> {
			UsuarioSistema usuarioSistema = userRepository.findByUsername(username)
					.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado na base dados"));

			return User.builder().username(usuarioSistema.getUsername())
								 .password(usuarioSistema.getPassword())
								 .roles("USER")
								 .build();
		};
	}
	
	@Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
