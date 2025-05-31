package br.com.fiap.projeto_redepapagaio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.fiap.projeto_redepapagaio.model.NivelUrgencia;
import br.com.fiap.projeto_redepapagaio.repository.NivelUrgenciaRepository;

@Service
public class NivelUrgenciaCachingService {

	@Autowired
	private NivelUrgenciaRepository repN;
	
	@Cacheable(value = "buscarTodosCache")
	public List<NivelUrgencia> findAll(){
		return repN.findAll();
	}
	
	@Cacheable(value = "buscarPorID", key = "#idNivelUrgencia")
	public Optional<NivelUrgencia> findById(Long idNivelUrgencia){
		return repN.findById(idNivelUrgencia);
	}
	
	@Cacheable(value = "buscarPaginasNivelUrgencias", key = "#req")
	public Page<NivelUrgencia> findAll(PageRequest req){
		return repN.findAll(req);
	}
	
	@CacheEvict(value = {"buscarTodosCache","buscarPorID", "buscarPaginasNivelUrgencias"},
			allEntries = true)
	public void limparCache() {
		System.out.println("Limpando cache!");
	}
}
