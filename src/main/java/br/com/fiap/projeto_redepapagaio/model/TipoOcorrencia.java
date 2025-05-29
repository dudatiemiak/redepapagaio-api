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
@Table(name = "t_ppg_tipo_ocorrencia")
public class TipoOcorrencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoOcorrencia;
	@NotEmpty(message = "O tipo da ocorrência deve ser informado!")
    @Size(max = 50, message = "O tipo da ocorrência deve ter no máximo 50 caracteres")
	@Column(name = "nm_tipo_ocorrencia")
	private TipoOcorrenciaEnum nmTipoOcorrencia;
}
