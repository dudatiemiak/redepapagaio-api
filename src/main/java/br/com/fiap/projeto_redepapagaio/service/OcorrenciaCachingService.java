package br.com.fiap.projeto_redepapagaio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.fiap.projeto_redepapagaio.model.Ocorrencia;
import br.com.fiap.projeto_redepapagaio.repository.OcorrenciaRepository;

@Service
public class OcorrenciaCachingService {

	@Autowired
	private OcorrenciaRepository repO;
	
	@Cacheable(value = "buscarTodosCache")
	public List<Ocorrencia> findAll(){
		return repO.findAll();
	}
	
	@Cacheable(value = "buscarPorID", key = "#idOcorrencia")
	public Optional<Ocorrencia> findById(Long idOcorrencia){
		return repO.findById(idOcorrencia);
	}
	
	@Cacheable(value = "buscarPaginasOcorrencias", key = "#req")
	public Page<Ocorrencia> findAll(PageRequest req){
		return repO.findAll(req);
	}
	
	@CacheEvict(value = {"buscarTodosCache","buscarPorID", "buscarPaginasOcorrencias"},
			allEntries = true)
	public void limparCache() {
		System.out.println("Limpando cache!");
	}
}
