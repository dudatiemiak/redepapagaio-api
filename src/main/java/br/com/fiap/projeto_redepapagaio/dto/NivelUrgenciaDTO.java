package br.com.fiap.projeto_redepapagaio.dto;

import org.springframework.hateoas.RepresentationModel;

import br.com.fiap.projeto_redepapagaio.model.NivelUrgenciaEnum;

public class NivelUrgenciaDTO extends RepresentationModel<NivelUrgenciaDTO>{
    private Long idNivelUrgencia;
    private NivelUrgenciaEnum nmNivel;
    
	public NivelUrgenciaDTO() {
	}

	public NivelUrgenciaDTO(Long idNivelUrgencia, NivelUrgenciaEnum nmNivel) {
		super();
		this.idNivelUrgencia = idNivelUrgencia;
		this.nmNivel = nmNivel;
	}

	public Long getIdNivelUrgencia() {
		return idNivelUrgencia;
	}

	public void setIdNivelUrgencia(Long idNivelUrgencia) {
		this.idNivelUrgencia = idNivelUrgencia;
	}

	public NivelUrgenciaEnum getNmNivel() {
		return nmNivel;
	}

	public void setNmNivel(NivelUrgenciaEnum nmNivel) {
		this.nmNivel = nmNivel;
	}
    
	
    



}
