package br.com.fiap.projeto_redepapagaio.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "t_ppg_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;
	@NotEmpty(message = "O nome do usuário deve ser informado!")
    @Size(max = 100, message = "O nome do usuário deve ter no máximo 100 caracteres")
	@Column(name = "nm_usuario")
	private String nmUsuario;
	@NotEmpty(message = "O nome do email usuário deve ser informado!")
    @Size(max = 100, message = "O nome do email do usuário deve ter no máximo 100 caracteres")
	@Column(name = "nm_email")
	private String nmEmail;
	@NotEmpty(message = "O nome da senha do usuário deve ser informado!")
    @Size(max = 100, message = "O nome da senha do usuário deve ter no máximo 255 caracteres")
	@Column(name = "nm_senha")
	private String nmSenha;
	@PastOrPresent(message = "Data inválida")
	@Column(name = "dt_cadastro")
	private LocalDate dtCadastro;
}
