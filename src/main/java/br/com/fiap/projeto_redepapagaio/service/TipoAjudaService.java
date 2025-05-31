package br.com.fiap.projeto_redepapagaio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.projeto_redepapagaio.dto.TipoAjudaDTO;
import br.com.fiap.projeto_redepapagaio.mapper.TipoAjudaMapperInterface;
import br.com.fiap.projeto_redepapagaio.model.TipoAjuda;

@Service
public class TipoAjudaService {

	@Autowired
	private TipoAjudaCachingService cacheTA;
	
	@Autowired
	private TipoAjudaMapperInterface mapperInterfaceTA;
	
	@Transactional(readOnly = true)
	public Page<TipoAjudaDTO> paginar(PageRequest req) {
		Page<TipoAjuda> tiposAjudas = cacheTA.findAll(req);
		Page<TipoAjudaDTO> tiposAjudasDTO = tiposAjudas.map(tipoAjuda -> mapperInterfaceTA.toDTO(tipoAjuda));
		return tiposAjudasDTO;
	} 
}
