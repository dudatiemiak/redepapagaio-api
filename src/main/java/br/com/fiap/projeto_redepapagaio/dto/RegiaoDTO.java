package br.com.fiap.projeto_redepapagaio.dto;

import org.springframework.hateoas.RepresentationModel;

public class RegiaoDTO extends RepresentationModel<RegiaoDTO>{
	private Long idRegiao;
	private String nmRegiao;
	private String nmCidade;
	private String nmEstado;
	
	public RegiaoDTO() {
	}
	
	public RegiaoDTO(Long idRegiao, String nmRegiao, String nmCidade, String nmEstado) {
		super();
		this.idRegiao = idRegiao;
		this.nmRegiao = nmRegiao;
		this.nmCidade = nmCidade;
		this.nmEstado = nmEstado;
	}
	public Long getIdRegiao() {
		return idRegiao;
	}
	public void setIdRegiao(Long idRegiao) {
		this.idRegiao = idRegiao;
	}
	public String getNmRegiao() {
		return nmRegiao;
	}
	public void setNmRegiao(String nmRegiao) {
		this.nmRegiao = nmRegiao;
	}
	public String getNmCidade() {
		return nmCidade;
	}
	public void setNmCidade(String nmCidade) {
		this.nmCidade = nmCidade;
	}
	public String getNmEstado() {
		return nmEstado;
	}
	public void setNmEstado(String nmEstado) {
		this.nmEstado = nmEstado;
	}
	
	

	
}
