package br.com.fiap.projeto_redepapagaio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.fiap.projeto_redepapagaio.dto.StatusOcorrenciaDTO;
import br.com.fiap.projeto_redepapagaio.model.StatusOcorrencia;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface StatusOcorrenciaMapperInterface {
	
	StatusOcorrenciaDTO toDTO(StatusOcorrencia statusOcorrencia);

	StatusOcorrencia toEntity(StatusOcorrenciaDTO dto);
}
