package br.com.fiap.projeto_redepapagaio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.projeto_redepapagaio.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	// Busca usuário por substring no nome, email ou senha, ordenado por nome
    @Query(nativeQuery = true, value = """
        SELECT * FROM t_ppg_usuario u
        WHERE u.nm_usuario LIKE CONCAT('%', :sub, '%')
           OR u.nm_email LIKE CONCAT('%', :sub, '%')
           OR u.nm_senha LIKE CONCAT('%', :sub, '%')
        ORDER BY u.nm_usuario ASC
    """)
    List<Usuario> buscarUsuarioPorSubstringOrdenadoPorNome(String sub);
	
    Optional<Usuario> findByUsername(String nmEmail);
}
