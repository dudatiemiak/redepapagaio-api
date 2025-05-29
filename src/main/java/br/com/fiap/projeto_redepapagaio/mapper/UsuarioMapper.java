package br.com.fiap.projeto_redepapagaio.mapper;

import org.springframework.stereotype.Component;

import br.com.fiap.projeto_redepapagaio.dto.UsuarioDTO;
import br.com.fiap.projeto_redepapagaio.model.Usuario;

@Component
public class UsuarioMapper {
	public UsuarioDTO toDTO(Usuario usuario) {

		UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setNmUsuario(usuario.getNmUsuario());
        dto.setNmEmail(usuario.getNmEmail());
        dto.setNmSenha(usuario.getNmSenha());
        dto.setDtCadastro(usuario.getDtCadastro());
        return dto;

    }
}
