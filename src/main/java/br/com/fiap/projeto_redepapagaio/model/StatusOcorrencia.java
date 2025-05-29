package br.com.fiap.projeto_redepapagaio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "t_ppg_status_ocorrencia")
public class StatusOcorrencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_status_ocorrencia")
	private Long idStatusOcorrencia;
	@NotEmpty(message = "O status da ocorrência deve ser informado!")
    @Size(max = 20, message = "O status da ocorrência deve ter no máximo 20 caracteres")
	@Column(name = "nm_status")
	private String nmStatus;
}
