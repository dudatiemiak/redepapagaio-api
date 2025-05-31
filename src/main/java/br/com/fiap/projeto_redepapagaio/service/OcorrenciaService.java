package br.com.fiap.projeto_redepapagaio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.projeto_redepapagaio.dto.OcorrenciaDTO;
import br.com.fiap.projeto_redepapagaio.mapper.OcorrenciaMapperInterface;
import br.com.fiap.projeto_redepapagaio.model.Ocorrencia;

@Service
public class OcorrenciaService {

	@Autowired
	private OcorrenciaCachingService cacheA;
	
	@Autowired
	private OcorrenciaMapperInterface mapperInterfaceO;
	
	@Transactional(readOnly = true)
	public Page<OcorrenciaDTO> paginar(PageRequest req) {
		Page<Ocorrencia> ocorrencias = cacheA.findAll(req);
		Page<OcorrenciaDTO> ocorrenciasDTO = ocorrencias.map(ocorrencia -> mapperInterfaceO.toDTO(ocorrencia));
		return ocorrenciasDTO;
	} 
}
