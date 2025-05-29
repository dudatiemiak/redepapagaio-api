package br.com.fiap.projeto_redepapagaio.dto;

import org.springframework.hateoas.RepresentationModel;

import br.com.fiap.projeto_redepapagaio.model.TipoAjudaEnum;

public class TipoAjudaDTO extends RepresentationModel<TipoAjudaDTO>{
	private Long idTipoAjuda;
	private TipoAjudaEnum nmTipoAjuda;
	
	public TipoAjudaDTO() {
	}

	public TipoAjudaDTO(Long idTipoAjuda, TipoAjudaEnum nmTipoAjuda) {
		super();
		this.idTipoAjuda = idTipoAjuda;
		this.nmTipoAjuda = nmTipoAjuda;
	}

	public Long getIdTipoAjuda() {
		return idTipoAjuda;
	}

	public void setIdTipoAjuda(Long idTipoAjuda) {
		this.idTipoAjuda = idTipoAjuda;
	}

	public TipoAjudaEnum getNmTipoAjuda() {
		return nmTipoAjuda;
	}

	public void setNmTipoAjuda(TipoAjudaEnum nmTipoAjuda) {
		this.nmTipoAjuda = nmTipoAjuda;
	}

	
}
