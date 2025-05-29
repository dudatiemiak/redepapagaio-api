package br.com.fiap.projeto_redepapagaio.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "t_ppg_ajuda_realizada")
public class AjudaRealizada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ajuda")
	private Long idAjuda;
	@ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @NotNull(message = "A ajuda realizada deve estar relacionada a um usuário")
	private Usuario usuario;
	@ManyToOne
    @JoinColumn(name = "id_ocorrencia", nullable = false)
    @NotNull(message = "A ajuda realizada deve estar relacionada a uma ocorrência")
	private Ocorrencia ocorrencia;
	@OneToOne
    @JoinColumn(name = "id_tipo_ajuda", nullable = false)
    @NotNull(message = "A ajuda realizada deve estar relacionada a um tipo de ajuda")
	private TipoAjuda tipoAjuda;
	@NotEmpty(message = "A descrição da ajuda deve ser informada!")
    @Size(max = 500, message = "A descrição da ajuda deve ter no máximo 500 caracteres")
	@Column(name = "ds_ajuda")
	private String dsAjuda;
	@PastOrPresent(message = "Data inválida")
	@Column(name = "dt_ajuda")
	private LocalDate dtAjuda;
	
}
