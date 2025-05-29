package br.com.fiap.projeto_redepapagaio.mapper;

import org.springframework.stereotype.Component;

import br.com.fiap.projeto_redepapagaio.dto.OcorrenciaDTO;
import br.com.fiap.projeto_redepapagaio.model.Ocorrencia;

@Component
public class OcorrenciaMapper {
	public OcorrenciaDTO toDTO(Ocorrencia ocorrencia) {

		OcorrenciaDTO dto = new OcorrenciaDTO();
        dto.setIdOcorrencia(ocorrencia.getIdOcorrencia());
        dto.setTipoOcorrencia(ocorrencia.getTipoOcorrencia());
        dto.setStatusOcorrencia(ocorrencia.getStatusOcorrencia());
        dto.setRegiao(ocorrencia.getRegiao());
        dto.setNivelUrgencia(ocorrencia.getNivelUrgencia());
        dto.setDsOcorrencia(ocorrencia.getDsOcorrencia());
        return dto;
        
    }
}
