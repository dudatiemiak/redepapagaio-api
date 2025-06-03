package br.com.fiap.projeto_redepapagaio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.projeto_redepapagaio.model.UsuarioSistema;

public interface UsuarioSistemaRepository extends JpaRepository<UsuarioSistema, Long>{

	Optional<UsuarioSistema> findByUsername(String username);
}
