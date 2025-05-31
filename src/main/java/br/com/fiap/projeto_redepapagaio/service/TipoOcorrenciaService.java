package br.com.fiap.projeto_redepapagaio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.projeto_redepapagaio.dto.TipoOcorrenciaDTO;
import br.com.fiap.projeto_redepapagaio.mapper.TipoOcorrenciaMapperInterface;
import br.com.fiap.projeto_redepapagaio.model.TipoOcorrencia;

@Service
public class TipoOcorrenciaService {

	@Autowired
	private TipoOcorrenciaCachingService cacheTO;
	
	@Autowired
	private TipoOcorrenciaMapperInterface mapperInterfaceTO;
	
	@Transactional(readOnly = true)
	public Page<TipoOcorrenciaDTO> paginar(PageRequest req) {
		Page<TipoOcorrencia> tiposOcorrencias = cacheTO.findAll(req);
		Page<TipoOcorrenciaDTO> tiposOcorrenciasDTO = tiposOcorrencias.map(tipoOcorrencia -> mapperInterfaceTO.toDTO(tipoOcorrencia));
		return tiposOcorrenciasDTO;
	} 
}
