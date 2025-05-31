package br.com.fiap.projeto_redepapagaio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.projeto_redepapagaio.dto.TelefoneDTO;
import br.com.fiap.projeto_redepapagaio.mapper.TelefoneMapperInterface;
import br.com.fiap.projeto_redepapagaio.model.Telefone;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneCachingService cacheT;
	
	@Autowired
	private TelefoneMapperInterface mapperInterfaceT;
	
	@Transactional(readOnly = true)
	public Page<TelefoneDTO> paginar(PageRequest req) {
		Page<Telefone> telefones = cacheT.findAll(req);
		Page<TelefoneDTO> telefonesDTO = telefones.map(telefone -> mapperInterfaceT.toDTO(telefone));
		return telefonesDTO;
	} 
}
