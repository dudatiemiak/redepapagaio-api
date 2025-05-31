package br.com.fiap.projeto_redepapagaio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.fiap.projeto_redepapagaio.dto.RegiaoDTO;
import br.com.fiap.projeto_redepapagaio.model.Regiao;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RegiaoMapperInterface {

	RegiaoDTO toDTO(Regiao regiao);

	Regiao toEntity(RegiaoDTO dto);
}
