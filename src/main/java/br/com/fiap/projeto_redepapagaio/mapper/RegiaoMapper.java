package br.com.fiap.projeto_redepapagaio.mapper;

import org.springframework.stereotype.Component;

import br.com.fiap.projeto_redepapagaio.dto.RegiaoDTO;
import br.com.fiap.projeto_redepapagaio.model.Regiao;

@Component
public class RegiaoMapper {
	public RegiaoDTO toDTO(Regiao regiao) {

		RegiaoDTO dto = new RegiaoDTO();
        dto.setIdRegiao(regiao.getIdRegiao());
        dto.setNmRegiao(regiao.getNmRegiao());
        dto.setNmCidade(regiao.getNmCidade());
        dto.setNmEstado(regiao.getNmEstado());
        dto.setNmPais(regiao.getNmPais());
        return dto;
        
    }
}
