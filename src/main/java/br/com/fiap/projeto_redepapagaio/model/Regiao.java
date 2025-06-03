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
@Table(name = "t_ppg_regiao")
public class Regiao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_regiao")
	private Long idRegiao;
	@NotEmpty(message = "O nome da região da ocorrência deve ser informado!")
    @Size(max = 100, message = "O nome da região da ocorrência deve ter no máximo 100 caracteres")
	@Column(name = "nm_regiao")
	private String nmRegiao;
	@Size(max = 100, message = "O nome da cidade da ocorrência deve ter no máximo 100 caracteres")
	@Column(name = "nm_cidade")
	private String nmCidade;
	@Size(max = 100, message = "O nome do estado da ocorrência deve ter no máximo 100 caracteres")
	@Column(name = "nm_estado")
	private String nmEstado;
	
}
