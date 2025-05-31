package br.com.fiap.projeto_redepapagaio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.fiap.projeto_redepapagaio.dto.TipoAjudaDTO;
import br.com.fiap.projeto_redepapagaio.model.TipoAjuda;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TipoAjudaMapperInterface {

	TipoAjudaDTO toDTO(TipoAjuda tipoAjuda);
	
	TipoAjuda toEntity(TipoAjudaDTO dto);
}
