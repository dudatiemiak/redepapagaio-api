package br.com.fiap.projeto_redepapagaio.dto;

import org.springframework.hateoas.RepresentationModel;

import br.com.fiap.projeto_redepapagaio.model.TipoOcorrenciaEnum;

public class TipoOcorrenciaDTO extends RepresentationModel<TipoOcorrenciaDTO>{
	private Long idTipoOcorrencia;
	private TipoOcorrenciaEnum nmTipoOcorrencia;
	
	public TipoOcorrenciaDTO() {
	}

	public TipoOcorrenciaDTO(Long idTipoOcorrencia, TipoOcorrenciaEnum nmTipoOcorrencia) {
		super();
		this.idTipoOcorrencia = idTipoOcorrencia;
		this.nmTipoOcorrencia = nmTipoOcorrencia;
	}

	public Long getIdTipoOcorrencia() {
		return idTipoOcorrencia;
	}

	public void setIdTipoOcorrencia(Long idTipoOcorrencia) {
		this.idTipoOcorrencia = idTipoOcorrencia;
	}

	public TipoOcorrenciaEnum getNmTipoOcorrencia() {
		return nmTipoOcorrencia;
	}

	public void setNmTipoOcorrencia(TipoOcorrenciaEnum nmTipoOcorrencia) {
		this.nmTipoOcorrencia = nmTipoOcorrencia;
	}

	
}
