package br.com.fiap.projeto_redepapagaio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.fiap.projeto_redepapagaio.dto.TipoOcorrenciaDTO;
import br.com.fiap.projeto_redepapagaio.model.TipoOcorrencia;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TipoOcorrenciaMapperInterface {

	TipoOcorrenciaDTO toDTO(TipoOcorrencia tipoOcorrencia);
	
	TipoOcorrencia toEntity(TipoOcorrenciaDTO dto);
}
