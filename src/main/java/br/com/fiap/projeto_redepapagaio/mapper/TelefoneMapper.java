package br.com.fiap.projeto_redepapagaio.mapper;

import org.springframework.stereotype.Component;

import br.com.fiap.projeto_redepapagaio.dto.TelefoneDTO;
import br.com.fiap.projeto_redepapagaio.model.Telefone;

@Component
public class TelefoneMapper {
	public TelefoneDTO toDTO(Telefone telefone) {

		TelefoneDTO dto = new TelefoneDTO();
        dto.setIdTelefone(telefone.getIdTelefone());
        dto.setUsuario(telefone.getUsuario());
        dto.setNrTelefone(telefone.getNrTelefone());
        dto.setNrDDD(telefone.getNrDDD());
        dto.setNrDDI(telefone.getNrDDI());
        return dto;

    }
}
