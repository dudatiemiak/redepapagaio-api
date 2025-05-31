package br.com.fiap.projeto_redepapagaio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.projeto_redepapagaio.dto.UsuarioDTO;
import br.com.fiap.projeto_redepapagaio.mapper.UsuarioMapperInterface;
import br.com.fiap.projeto_redepapagaio.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioCachingService cacheU;
	
	@Autowired
	private UsuarioMapperInterface mapperInterfaceU;
	
	@Transactional(readOnly = true)
	public Page<UsuarioDTO> paginar(PageRequest req) {
		Page<Usuario> usuarios = cacheU.findAll(req);
		Page<UsuarioDTO> usuariosDTO = usuarios.map(usuario -> mapperInterfaceU.toDTO(usuario));
		return usuariosDTO;
	} 
}
