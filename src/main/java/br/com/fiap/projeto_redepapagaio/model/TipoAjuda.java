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
@Table(name = "t_ppg_tipo_ajuda")
public class TipoAjuda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_ajuda")
	private Long idTipoAjuda;
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O tipo de ajuda deve ser informado!")
	@Column(name = "nm_tipo_ajuda")
	private TipoAjudaEnum nmTipoAjuda;
}
