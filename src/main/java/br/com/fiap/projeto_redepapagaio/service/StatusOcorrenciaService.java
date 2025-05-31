package br.com.fiap.projeto_redepapagaio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.projeto_redepapagaio.dto.StatusOcorrenciaDTO;
import br.com.fiap.projeto_redepapagaio.mapper.StatusOcorrenciaMapperInterface;
import br.com.fiap.projeto_redepapagaio.model.StatusOcorrencia;

@Service
public class StatusOcorrenciaService {

	@Autowired
	private StatusOcorrenciaCachingService cacheS;
	
	@Autowired
	private StatusOcorrenciaMapperInterface mapperInterfaceS;
	
	@Transactional(readOnly = true)
	public Page<StatusOcorrenciaDTO> paginar(PageRequest req) {
		Page<StatusOcorrencia> statusOcorrencias = cacheS.findAll(req);
		Page<StatusOcorrenciaDTO> statusOcorrenciasDTO = statusOcorrencias.map(statusOcorrencia -> mapperInterfaceS.toDTO(statusOcorrencia));
		return statusOcorrenciasDTO;
	} 
}
