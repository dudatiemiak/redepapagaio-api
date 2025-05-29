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
@Table(name = "t_ppg_tipo_ajuda")
public class TipoAjuda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_ajuda")
	private Long idTipoAjuda;
	@NotEmpty(message = "O tipo de ajuda deve ser informado!")
    @Size(max = 50, message = "O tipo de ajuda deve ter no máximo 50 caracteres")
	@Column(name = "nm_tipo_ajuda")
	private TipoAjudaEnum nmTipoAjuda;
}
