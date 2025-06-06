package br.com.fiap.projeto_redepapagaio.security;

public class JwtResponse {
    private String token;

    // Construtor
    public JwtResponse(String token) {
        this.token = token;
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
