package br.com.fiap.projeto_redepapagaio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.fiap.projeto_redepapagaio.dto.AjudaRealizadaDTO;
import br.com.fiap.projeto_redepapagaio.model.AjudaRealizada;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AjudaRealizadaMapperInterface {
	
	AjudaRealizadaDTO toDTO(AjudaRealizada ajuda);

    AjudaRealizada toEntity(AjudaRealizadaDTO dto);
}
