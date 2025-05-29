package br.com.fiap.projeto_redepapagaio.dto;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

public class UsuarioDTO extends RepresentationModel<UsuarioDTO>{
	private Long idUsuario;
	private String nmUsuario;
	private String nmEmail;
	private String nmSenha;
	private LocalDate dtCadastro;
	
	public UsuarioDTO() {
	}

	public UsuarioDTO(Long idUsuario, String nmUsuario, String nmEmail, String nmSenha, LocalDate dtCadastro) {
		super();
		this.idUsuario = idUsuario;
		this.nmUsuario = nmUsuario;
		this.nmEmail = nmEmail;
		this.nmSenha = nmSenha;
		this.dtCadastro = dtCadastro;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNmUsuario() {
		return nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public String getNmEmail() {
		return nmEmail;
	}

	public void setNmEmail(String nmEmail) {
		this.nmEmail = nmEmail;
	}

	public String getNmSenha() {
		return nmSenha;
	}

	public void setNmSenha(String nmSenha) {
		this.nmSenha = nmSenha;
	}

	public LocalDate getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(LocalDate dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	
}
