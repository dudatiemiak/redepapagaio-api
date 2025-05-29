package br.com.fiap.projeto_redepapagaio.mapper;

import org.springframework.stereotype.Component;

import br.com.fiap.projeto_redepapagaio.dto.StatusOcorrenciaDTO;
import br.com.fiap.projeto_redepapagaio.model.StatusOcorrencia;

@Component
public class StatusOcorrenciaMapper {
	public StatusOcorrenciaDTO toDTO(StatusOcorrencia statusOcorrencia) {

		StatusOcorrenciaDTO dto = new StatusOcorrenciaDTO();
        dto.setIdStatusOcorrencia(statusOcorrencia.getIdStatusOcorrencia());
        dto.setNmStatus(statusOcorrencia.getNmStatus());
        return dto;

    }
}
