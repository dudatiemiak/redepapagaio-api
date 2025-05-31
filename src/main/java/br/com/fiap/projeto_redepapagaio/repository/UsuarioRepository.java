package br.com.fiap.projeto_redepapagaio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.projeto_redepapagaio.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
