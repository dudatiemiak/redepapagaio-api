package br.com.fiap.projeto_redepapagaio.dto;

import org.springframework.hateoas.RepresentationModel;

import br.com.fiap.projeto_redepapagaio.model.Usuario;

public class TelefoneDTO extends RepresentationModel<TelefoneDTO>{
	private Long idTelefone;
	private Usuario usuario;
	private String nrTelefone;
	private String nrDDD;
	private String nrDDI;
	
	public TelefoneDTO() {
	}

	public TelefoneDTO(Long idTelefone, Usuario usuario, String nrTelefone, String nrDDD, String nrDDI) {
		super();
		this.idTelefone = idTelefone;
		this.usuario = usuario;
		this.nrTelefone = nrTelefone;
		this.nrDDD = nrDDD;
		this.nrDDI = nrDDI;
	}

	public Long getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNrTelefone() {
		return nrTelefone;
	}

	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public String getNrDDD() {
		return nrDDD;
	}

	public void setNrDDD(String nrDDD) {
		this.nrDDD = nrDDD;
	}

	public String getNrDDI() {
		return nrDDI;
	}

	public void setNrDDI(String nrDDI) {
		this.nrDDI = nrDDI;
	}
	
	
	

}
