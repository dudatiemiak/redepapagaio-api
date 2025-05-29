package br.com.fiap.projeto_redepapagaio.dto;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

import br.com.fiap.projeto_redepapagaio.model.Ocorrencia;
import br.com.fiap.projeto_redepapagaio.model.TipoAjuda;
import br.com.fiap.projeto_redepapagaio.model.Usuario;


public class AjudaRealizadaDTO extends RepresentationModel<AjudaRealizadaDTO>{
	private Long idAjudaRealizada;
	private Usuario usuario;
	private Ocorrencia ocorrencia;
	private TipoAjuda tipoAjuda;
	private String dsAjuda;
	private LocalDate dtAjuda;
	
	public AjudaRealizadaDTO() {
	}

	public AjudaRealizadaDTO(Long idAjudaRealizada, Usuario usuario, Ocorrencia ocorrencia, TipoAjuda tipoAjuda,
			String dsAjuda, LocalDate dtAjuda) {
		super();
		this.idAjudaRealizada = idAjudaRealizada;
		this.usuario = usuario;
		this.ocorrencia = ocorrencia;
		this.tipoAjuda = tipoAjuda;
		this.dsAjuda = dsAjuda;
		this.dtAjuda = dtAjuda;
	}

	public Long getIdAjudaRealizada() {
		return idAjudaRealizada;
	}

	public void setIdAjudaRealizada(Long idAjudaRealizada) {
		this.idAjudaRealizada = idAjudaRealizada;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public TipoAjuda getTipoAjuda() {
		return tipoAjuda;
	}

	public void setTipoAjuda(TipoAjuda tipoAjuda) {
		this.tipoAjuda = tipoAjuda;
	}

	public String getDsAjuda() {
		return dsAjuda;
	}

	public void setDsAjuda(String dsAjuda) {
		this.dsAjuda = dsAjuda;
	}

	public LocalDate getDtAjuda() {
		return dtAjuda;
	}

	public void setDtAjuda(LocalDate dtAjuda) {
		this.dtAjuda = dtAjuda;
	}
	
	
	
	
}
