package br.com.fiap.projeto_redepapagaio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.fiap.projeto_redepapagaio.dto.TelefoneDTO;
import br.com.fiap.projeto_redepapagaio.model.Telefone;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TelefoneMapperInterface {
	
	TelefoneDTO toDTO(Telefone telefone);
	
	Telefone toEntity(TelefoneDTO dto);
}
