package br.com.fiap.projeto_redepapagaio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.fiap.projeto_redepapagaio.model.Usuario;
import br.com.fiap.projeto_redepapagaio.repository.UsuarioRepository;

@Service
public class UsuarioCachingService {

	@Autowired
	private UsuarioRepository repU;
	
	@Cacheable(value = "buscarTodosCache")
	public List<Usuario> findAll(){
		return repU.findAll();
	}
	
	@Cacheable(value = "buscarPorID", key = "#idUsuario")
	public Optional<Usuario> findById(Long idUsuario){
		return repU.findById(idUsuario);
	}

	@Cacheable(value= "buscarPorEmail", key = "#email")
	public Optional<Usuario> findByEmail(String email) {
		return repU.findByNmEmail(email);
	}
	
	@Cacheable(value = "buscarPaginasUsuarios", key = "#req")
	public Page<Usuario> findAll(PageRequest req){
		return repU.findAll(req);
	}
	
	@CacheEvict(value = {"buscarTodosCache","buscarPorID", "buscarPaginasUsuarios"},
			allEntries = true)
	public void limparCache() {
		System.out.println("Limpando cache!");
	}

}
