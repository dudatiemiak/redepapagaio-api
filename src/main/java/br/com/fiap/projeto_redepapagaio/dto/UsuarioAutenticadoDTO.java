package br.com.fiap.projeto_redepapagaio.dto;

import lombok.Data;

@Data

public class UsuarioAutenticadoDTO {
    private String token;
    private Long idUsuario;
}
