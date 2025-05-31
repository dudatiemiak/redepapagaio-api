package br.com.fiap.projeto_redepapagaio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.projeto_redepapagaio.dto.NivelUrgenciaDTO;
import br.com.fiap.projeto_redepapagaio.mapper.NivelUrgenciaMapperInterface;
import br.com.fiap.projeto_redepapagaio.model.NivelUrgencia;

@Service
public class NivelUrgenciaService {

	@Autowired
	private NivelUrgenciaCachingService cacheN;
	
	@Autowired
	private NivelUrgenciaMapperInterface mapperInterfaceN;
	
	@Transactional(readOnly = true)
	public Page<NivelUrgenciaDTO> paginar(PageRequest req) {
		Page<NivelUrgencia> nivelUrgencias = cacheN.findAll(req);
		Page<NivelUrgenciaDTO> nivelUrgenciaDTO = nivelUrgencias.map(nivelUrgencia -> mapperInterfaceN.toDTO(nivelUrgencia));
		return nivelUrgenciaDTO;
	} 
}
