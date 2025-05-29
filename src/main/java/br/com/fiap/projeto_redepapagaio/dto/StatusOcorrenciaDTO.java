package br.com.fiap.projeto_redepapagaio.dto;

import org.springframework.hateoas.RepresentationModel;

public class StatusOcorrenciaDTO extends RepresentationModel<StatusOcorrenciaDTO>{
	private Long idStatusOcorrencia;
	private String nmStatus;
	
	public StatusOcorrenciaDTO() {
	}

	public StatusOcorrenciaDTO(Long idStatusOcorrencia, String nmStatus) {
		super();
		this.idStatusOcorrencia = idStatusOcorrencia;
		this.nmStatus = nmStatus;
	}

	public Long getIdStatusOcorrencia() {
		return idStatusOcorrencia;
	}

	public void setIdStatusOcorrencia(Long idStatusOcorrencia) {
		this.idStatusOcorrencia = idStatusOcorrencia;
	}

	public String getNmStatus() {
		return nmStatus;
	}

	public void setNmStatus(String nmStatus) {
		this.nmStatus = nmStatus;
	}
	
}
