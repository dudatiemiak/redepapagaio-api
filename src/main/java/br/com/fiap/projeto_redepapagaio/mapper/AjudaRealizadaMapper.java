package br.com.fiap.projeto_redepapagaio.mapper;

import br.com.fiap.projeto_redepapagaio.dto.AjudaRealizadaDTO;
import br.com.fiap.projeto_redepapagaio.model.AjudaRealizada;
import org.springframework.stereotype.Component;

@Component
public class AjudaRealizadaMapper {

    public AjudaRealizadaDTO toDTO(AjudaRealizada ajudaRealizada) {

        AjudaRealizadaDTO dto = new AjudaRealizadaDTO();
        dto.setIdAjudaRealizada(ajudaRealizada.getI);
        dto.setOcorrencia(ajudaRealizada.getOcorrencia());
        dto.setTipoAjuda(ajudaRealizada.getTipoAjuda());
        dto.setUsuario(ajudaRealizada.getUsuario());
        dto.setDsAjuda(ajudaRealizada.getDsAjuda());
        dto.setDtAjuda(ajudaRealizada.getDtAjuda());
        return dto;

    }
}
