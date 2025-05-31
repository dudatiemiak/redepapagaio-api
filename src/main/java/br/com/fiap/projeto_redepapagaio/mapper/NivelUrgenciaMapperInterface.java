package br.com.fiap.projeto_redepapagaio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.fiap.projeto_redepapagaio.dto.NivelUrgenciaDTO;
import br.com.fiap.projeto_redepapagaio.model.NivelUrgencia;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface NivelUrgenciaMapperInterface {

	NivelUrgenciaDTO toDTO(NivelUrgencia nivelUrgencia);

	NivelUrgencia toEntity(NivelUrgenciaDTO dto);
}
