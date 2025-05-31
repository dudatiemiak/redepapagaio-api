package br.com.fiap.projeto_redepapagaio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.projeto_redepapagaio.dto.RegiaoDTO;
import br.com.fiap.projeto_redepapagaio.mapper.RegiaoMapperInterface;
import br.com.fiap.projeto_redepapagaio.model.Regiao;

@Service
public class RegiaoService {

	@Autowired
	private RegiaoCachingService cacheR;
	
	@Autowired
	private RegiaoMapperInterface mapperInterfaceR;
	
	@Transactional(readOnly = true)
	public Page<RegiaoDTO> paginar(PageRequest req) {
		Page<Regiao> regioes = cacheR.findAll(req);
		Page<RegiaoDTO> regioesDTO = regioes.map(regiao -> mapperInterfaceR.toDTO(regiao));
		return regioesDTO;
	} 
}
