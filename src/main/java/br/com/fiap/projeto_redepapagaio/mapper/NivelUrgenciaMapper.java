package br.com.fiap.projeto_redepapagaio.mapper;

import org.springframework.stereotype.Component;

import br.com.fiap.projeto_redepapagaio.dto.NivelUrgenciaDTO;
import br.com.fiap.projeto_redepapagaio.model.NivelUrgencia;


@Component
public class NivelUrgenciaMapper {
	public NivelUrgenciaDTO toDTO(NivelUrgencia nivelUrgencia) {

		NivelUrgenciaDTO dto = new NivelUrgenciaDTO();
        dto.setIdNivelUrgencia(nivelUrgencia.getIdNivelUrgencia());
        dto.setNmNivel(nivelUrgencia.getNmNivel());
        return dto;
        
    }
}
