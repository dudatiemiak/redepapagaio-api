package br.com.fiap.projeto_redepapagaio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.fiap.projeto_redepapagaio.model.Regiao;
import br.com.fiap.projeto_redepapagaio.repository.RegiaoRepository;

@Service
public class RegiaoCachingService {

	@Autowired
	private RegiaoRepository repR;
	
	@Cacheable(value = "buscarTodosCache")
	public List<Regiao> findAll(){
		return repR.findAll();
	}
	
	@Cacheable(value = "buscarPorID", key = "#idRegiao")
	public Optional<Regiao> findById(Long idRegiao){
		return repR.findById(idRegiao);
	}
	
	@Cacheable(value = "buscarPaginasRegioes", key = "#req")
	public Page<Regiao> findAll(PageRequest req){
		return repR.findAll(req);
	}
	
	@CacheEvict(value = {"buscarTodosCache","buscarPorID", "buscarPaginasRegioes"},
			allEntries = true)
	public void limparCache() {
		System.out.println("Limpando cache!");
	}
}
