package br.com.fiap.projeto_redepapagaio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fiap.projeto_redepapagaio.model.Usuario;
import br.com.fiap.projeto_redepapagaio.repository.UsuarioRepository;

@Configuration
public class UsuarioConfig {

	@Autowired
	private UsuarioRepository repU;

	@Bean
	UserDetailsService gerarUsuario() {

		return username -> {
			Usuario usuario = repU.findByUsername(username)
					.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado na base dados"));

			return User.builder().username(usuario.getNmEmail())
								 .password(usuario.getNmSenha())
								 .roles("USER")
								 .build();
		};
	}
	
	@Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
