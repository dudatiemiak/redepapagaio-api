package br.com.fiap.projeto_redepapagaio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.fiap.projeto_redepapagaio.model.StatusOcorrencia;
import br.com.fiap.projeto_redepapagaio.repository.StatusOcorrenciaRepository;

@Service
public class StatusOcorrenciaCachingService {

	@Autowired
	private StatusOcorrenciaRepository repS;
	
	@Cacheable(value = "buscarTodosCache")
	public List<StatusOcorrencia> findAll(){
		return repS.findAll();
	}
	
	@Cacheable(value = "buscarPorID", key = "#idStatusOcorrencia")
	public Optional<StatusOcorrencia> findById(Long idStatusOcorrencia){
		return repS.findById(idStatusOcorrencia);
	}
	
	@Cacheable(value = "buscarPaginasStatusOcorrencias", key = "#req")
	public Page<StatusOcorrencia> findAll(PageRequest req){
		return repS.findAll(req);
	}
	
	@CacheEvict(value = {"buscarTodosCache","buscarPorID", "buscarPaginasStatusOcorrencias"},
			allEntries = true)
	public void limparCache() {
		System.out.println("Limpando cache!");
	}
}
