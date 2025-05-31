package br.com.fiap.projeto_redepapagaio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.fiap.projeto_redepapagaio.model.AjudaRealizada;
import br.com.fiap.projeto_redepapagaio.repository.AjudaRealizadaRepository;

@Service
public class AjudaRealizadaCachingService {

	@Autowired
	private AjudaRealizadaRepository repC;
	
	@Cacheable(value = "buscarTodosCache")
	public List<AjudaRealizada> findAll(){
		return repC.findAll();
	}
	
	@Cacheable(value = "buscarPorID", key = "#id_ajuda")
	public Optional<AjudaRealizada> findById(Long id_ajuda){
		return repC.findById(id_ajuda);
	}
	
	@Cacheable(value = "buscarPaginasAjudas", key = "#req")
	public Page<AjudaRealizada> findAll(PageRequest req){
		return repC.findAll(req);
	}
	
	@CacheEvict(value = {"buscarTodosCache","buscarPorID", "buscarPaginasAjudas"},
			allEntries = true)
	public void limparCache() {
		System.out.println("Limpando cache!");
	}
}
