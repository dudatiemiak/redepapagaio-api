package br.com.fiap.projeto_redepapagaio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "t_ppg_nivel_urgencia")
public class NivelUrgencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_nivel_urgencia")
	private Long idNivelUrgencia;
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O nível de urgência da ocorrência deve ser informado!")
	@Column(name = "nm_nivel")
	private NivelUrgenciaEnum nmNivel;
}
