package br.com.fiap.projeto_redepapagaio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.fiap.projeto_redepapagaio.model.Telefone;
import br.com.fiap.projeto_redepapagaio.repository.TelefoneRepository;

@Service
public class TelefoneCachingService {

	@Autowired
	private TelefoneRepository repT;
	
	@Cacheable(value = "buscarTodosCache")
	public List<Telefone> findAll(){
		return repT.findAll();
	}
	
	@Cacheable(value = "buscarPorID", key = "#idTelefone")
	public Optional<Telefone> findById(Long idTelefone){
		return repT.findById(idTelefone);
	}
	
	@Cacheable(value = "buscarPaginasTelefones", key = "#req")
	public Page<Telefone> findAll(PageRequest req){
		return repT.findAll(req);
	}
	
	@CacheEvict(value = {"buscarTodosCache","buscarPorID", "buscarPaginasTelefones"},
			allEntries = true)
	public void limparCache() {
		System.out.println("Limpando cache!");
	}
}
