package br.com.fiap.projeto_redepapagaio.mapper;

import org.springframework.stereotype.Component;

import br.com.fiap.projeto_redepapagaio.dto.TipoOcorrenciaDTO;
import br.com.fiap.projeto_redepapagaio.model.TipoOcorrencia;

@Component
public class TipoOcorrenciaMapper {
	public TipoOcorrenciaDTO toDTO(TipoOcorrencia tipoOcorrencia) {

		TipoOcorrenciaDTO dto = new TipoOcorrenciaDTO();
        dto.setIdTipoOcorrencia(tipoOcorrencia.getIdTipoOcorrencia());
        dto.setNmTipoOcorrencia(tipoOcorrencia.getNmTipoOcorrencia());
        return dto;

    }
}
