package br.com.fiap.projeto_redepapagaio.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.projeto_redepapagaio.dto.UsuarioDTO;
import br.com.fiap.projeto_redepapagaio.model.Usuario;
import br.com.fiap.projeto_redepapagaio.repository.UsuarioRepository;
import br.com.fiap.projeto_redepapagaio.service.UsuarioCachingService;
import br.com.fiap.projeto_redepapagaio.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
    private UsuarioRepository repU;

    @Autowired
    private UsuarioCachingService cacheU;

    @Autowired
    private UsuarioService servU;

    @GetMapping("/todos")
    public List<Usuario> listarTodosUsuarios() {
        return repU.findAll();
    }

    @GetMapping("/todos_cacheable")
    public List<Usuario> listarTodosUsuariosComCache() {
        return cacheU.findAll();
    }

    @GetMapping("/paginados")
    public ResponseEntity<Page<UsuarioDTO>> paginar(
    		@RequestParam(value = "pagina", defaultValue = "0") Integer page,
			@RequestParam(value = "tamanho", defaultValue = "2") Integer size) {

        PageRequest req = PageRequest.of(page, size);
        Page<UsuarioDTO> paginas = servU.paginar(req);

        return ResponseEntity.ok(paginas);
    }

    @GetMapping("/{id_usuario}")
    public Usuario buscarPorId(@PathVariable Long id_usuario) {
        Optional<Usuario> op = cacheU.findById(id_usuario);
        if (op.isPresent()) {
            return op.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/inserir")
    public Usuario inserirUsuario(@RequestBody Usuario usuario) {
        repU.save(usuario);
        cacheU.limparCache();
        return usuario;
    }

    @PutMapping("/atualizar/{id_usuario}")
    public Usuario atualizarUsuario(@RequestBody Usuario usuario, @PathVariable Long id_usuario) {
        Optional<Usuario> op = cacheU.findById(id_usuario);

        if (op.isPresent()) {
        	
            Usuario usuarioAtual = op.get();
            usuarioAtual.setNmUsuario(usuario.getNmUsuario());
            usuarioAtual.setNmEmail(usuario.getNmEmail());
            usuarioAtual.setNmSenha(usuario.getNmSenha());
            usuarioAtual.setDtCadastro(usuario.getDtCadastro());

            repU.save(usuarioAtual);
            cacheU.limparCache();

            return usuarioAtual;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/remover/{id_usuario}")
    public Usuario removerUsuario(@PathVariable Long id_usuario) {
        Optional<Usuario> op = cacheU.findById(id_usuario);

        if (op.isPresent()) {
            Usuario usuario = op.get();
            repU.delete(usuario);
            cacheU.limparCache();
            return usuario;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Usuario>> buscarUsuarioPorSubstring(@RequestParam("filtro") String filtro) {
        List<Usuario> usuarios = repU.buscarUsuarioPorSubstringOrdenadoPorNome(filtro);
        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarios);
    }
}
