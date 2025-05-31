package br.com.fiap.projeto_redepapagaio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.fiap.projeto_redepapagaio.dto.OcorrenciaDTO;
import br.com.fiap.projeto_redepapagaio.model.Ocorrencia;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface OcorrenciaMapperInterface {

	OcorrenciaDTO toDTO(Ocorrencia ocorrencia);

	Ocorrencia toEntity(OcorrenciaDTO dto);
}
