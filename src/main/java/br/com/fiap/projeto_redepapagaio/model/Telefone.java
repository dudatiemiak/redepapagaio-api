package br.com.fiap.projeto_redepapagaio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "t_ppg_telefone")
public class Telefone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTelefone;
	@ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @NotNull(message = "O telefone deve estar vinculado a um usuário")
	private Usuario usuario;
	@NotEmpty(message = "O número de telefone não pode estar em branco")
    @Size(max = 15, message = "O número de telefone deve ter no máximo 15 caracteres")
	@Column(name = "nr_telefone")
	private String nrTelefone;
	@NotEmpty(message = "O DDD não pode estar em branco")
    @Size(max = 5, message = "O DDD deve ter no máximo 5 caracteres")
	@Column(name = "nr_ddd")
	private String nrDDD;
	@NotEmpty(message = "O DDI não pode estar em branco")
    @Size(max = 4, message = "O DDI deve ter no máximo 4 caracteres")
	@Column(name = "nr_ddi")
	private String nrDDI;
}
