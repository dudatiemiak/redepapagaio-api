package br.com.fiap.projeto_redepapagaio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.fiap.projeto_redepapagaio.model.TipoAjuda;
import br.com.fiap.projeto_redepapagaio.repository.TipoAjudaRepository;

@Service
public class TipoAjudaCachingService {

	@Autowired
	private TipoAjudaRepository repTA;
	
	@Cacheable(value = "buscarTodosCache")
	public List<TipoAjuda> findAll(){
		return repTA.findAll();
	}
	
	@Cacheable(value = "buscarPorID", key = "#idTipoAjuda")
	public Optional<TipoAjuda> findById(Long idTipoAjuda){
		return repTA.findById(idTipoAjuda);
	}
	
	@Cacheable(value = "buscarPaginasTiposAjudas", key = "#req")
	public Page<TipoAjuda> findAll(PageRequest req){
		return repTA.findAll(req);
	}
	
	@CacheEvict(value = {"buscarTodosCache","buscarPorID", "buscarPaginasTiposAjudas"},
			allEntries = true)
	public void limparCache() {
		System.out.println("Limpando cache!");
	}
}
