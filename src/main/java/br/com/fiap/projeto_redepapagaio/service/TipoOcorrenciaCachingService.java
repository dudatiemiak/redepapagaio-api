package br.com.fiap.projeto_redepapagaio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.fiap.projeto_redepapagaio.model.TipoOcorrencia;
import br.com.fiap.projeto_redepapagaio.repository.TipoOcorrenciaRepository;

@Service
public class TipoOcorrenciaCachingService {

	@Autowired
	private TipoOcorrenciaRepository repTO;
	
	@Cacheable(value = "buscarTodosCache")
	public List<TipoOcorrencia> findAll(){
		return repTO.findAll();
	}
	
	@Cacheable(value = "buscarPorID", key = "#idTipoOcorrencia")
	public Optional<TipoOcorrencia> findById(Long idTipoOcorrencia){
		return repTO.findById(idTipoOcorrencia);
	}
	
	@Cacheable(value = "buscarPaginasTiposOcorrencias", key = "#req")
	public Page<TipoOcorrencia> findAll(PageRequest req){
		return repTO.findAll(req);
	}
	
	@CacheEvict(value = {"buscarTodosCache","buscarPorID", "buscarPaginasTiposOcorrencias"},
			allEntries = true)
	public void limparCache() {
		System.out.println("Limpando cache!");
	}
}
