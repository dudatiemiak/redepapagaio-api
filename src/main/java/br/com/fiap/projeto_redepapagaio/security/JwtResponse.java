package br.com.fiap.projeto_redepapagaio.security;

public class JwtResponse {
    private String token;
    private Long idUsuario;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    // Construtor
    public JwtResponse(String token, Long idUsuario) {
        this.token = token;
        this.idUsuario = idUsuario;
    }

    // Getter
    public String getToken() {
        return token;
    }

    // Setter
    public void setToken(String token) {
        this.token = token;
    }
}
