package br.com.fiap.projeto_redepapagaio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "t_ppg_ocorrencia")
public class Ocorrencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOcorrencia;
	@OneToOne
    @JoinColumn(name = "id_status_ocorrencia", nullable = false)
    @NotNull(message = "A ocorrência deve estar relacionado a um status")
	private StatusOcorrencia statusOcorrencia;
	@OneToOne
    @JoinColumn(name = "id_nivel_urgencia", nullable = false)
    @NotNull(message = "A ocorrência deve estar relacionado a um nível de urgência")
	private NivelUrgencia nivelUrgencia;
	@OneToOne
    @JoinColumn(name = "id_regiao", nullable = false)
    @NotNull(message = "A ocorrência deve estar relacionado a uma região")
	private Regiao regiao;
	@OneToOne
    @JoinColumn(name = "id_tipo_ocorrencia", nullable = false)
    @NotNull(message = "A ocorrência deve estar relacionado a um tipo")
	private TipoOcorrencia tipoOcorrencia;
	@NotEmpty(message = "A descrição da ocorrência deve ser informado!")
    @Size(max = 100, message = "A descrição da ocorrência deve ter no máximo 100 caracteres")
	@Column(name = "ds_ocorrencia")
	private String dsOcorrencia;
}
