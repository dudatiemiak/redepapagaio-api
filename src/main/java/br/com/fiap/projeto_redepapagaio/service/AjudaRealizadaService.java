package br.com.fiap.projeto_redepapagaio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import br.com.fiap.projeto_redepapagaio.dto.AjudaRealizadaDTO;
import br.com.fiap.projeto_redepapagaio.mapper.AjudaRealizadaMapperInterface;
import br.com.fiap.projeto_redepapagaio.model.AjudaRealizada;

@Service
public class AjudaRealizadaService {

	@Autowired
	private AjudaRealizadaCachingService cacheA;
	
	@Autowired
	private AjudaRealizadaMapperInterface mapperInterfaceA;
	
	@Transactional(readOnly = true)
	public Page<AjudaRealizadaDTO> paginar(PageRequest req) {
		Page<AjudaRealizada> ajudas = cacheA.findAll(req);
		Page<AjudaRealizadaDTO> ajudasDTO = ajudas.map(ajuda -> mapperInterfaceA.toDTO(ajuda));
		return ajudasDTO;
	} 
}
