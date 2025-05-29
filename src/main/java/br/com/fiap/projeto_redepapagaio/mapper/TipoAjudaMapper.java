package br.com.fiap.projeto_redepapagaio.mapper;

import org.springframework.stereotype.Component;

import br.com.fiap.projeto_redepapagaio.dto.TipoAjudaDTO;
import br.com.fiap.projeto_redepapagaio.model.TipoAjuda;

@Component
public class TipoAjudaMapper {
	public TipoAjudaDTO toDTO(TipoAjuda tipoAjuda) {

		TipoAjudaDTO dto = new TipoAjudaDTO();
        dto.setIdTipoAjuda(tipoAjuda.getIdTipoAjuda());
        dto.setNmTipoAjuda(tipoAjuda.getNmTipoAjuda());
        return dto;

    }
}
