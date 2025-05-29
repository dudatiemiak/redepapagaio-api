package br.com.fiap.projeto_redepapagaio.dto;

import org.springframework.hateoas.RepresentationModel;

import br.com.fiap.projeto_redepapagaio.model.NivelUrgencia;
import br.com.fiap.projeto_redepapagaio.model.Regiao;
import br.com.fiap.projeto_redepapagaio.model.StatusOcorrencia;
import br.com.fiap.projeto_redepapagaio.model.TipoOcorrencia;

public class OcorrenciaDTO extends RepresentationModel<OcorrenciaDTO>{
	
	private Long idOcorrencia;
	private StatusOcorrencia statusOcorrencia;
	private NivelUrgencia nivelUrgencia;
	private Regiao regiao;
	private TipoOcorrencia tipoOcorrencia;
	private String dsOcorrencia;
	
	public OcorrenciaDTO() {
	}

	public OcorrenciaDTO(Long idOcorrencia, StatusOcorrencia statusOcorrencia, NivelUrgencia nivelUrgencia,
			Regiao regiao, TipoOcorrencia tipoOcorrencia, String dsOcorrencia) {
		super();
		this.idOcorrencia = idOcorrencia;
		this.statusOcorrencia = statusOcorrencia;
		this.nivelUrgencia = nivelUrgencia;
		this.regiao = regiao;
		this.tipoOcorrencia = tipoOcorrencia;
		this.dsOcorrencia = dsOcorrencia;
	}

	public Long getIdOcorrencia() {
		return idOcorrencia;
	}

	public void setIdOcorrencia(Long idOcorrencia) {
		this.idOcorrencia = idOcorrencia;
	}

	public StatusOcorrencia getStatusOcorrencia() {
		return statusOcorrencia;
	}

	public void setStatusOcorrencia(StatusOcorrencia statusOcorrencia) {
		this.statusOcorrencia = statusOcorrencia;
	}

	public NivelUrgencia getNivelUrgencia() {
		return nivelUrgencia;
	}

	public void setNivelUrgencia(NivelUrgencia nivelUrgencia) {
		this.nivelUrgencia = nivelUrgencia;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public TipoOcorrencia getTipoOcorrencia() {
		return tipoOcorrencia;
	}

	public void setTipoOcorrencia(TipoOcorrencia tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
	}

	public String getDsOcorrencia() {
		return dsOcorrencia;
	}

	public void setDsOcorrencia(String dsOcorrencia) {
		this.dsOcorrencia = dsOcorrencia;
	}
	
	
	
	
}
