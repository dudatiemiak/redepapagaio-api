package br.com.fiap.projeto_redepapagaio.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.projeto_redepapagaio.dto.TipoAjudaDTO;
import br.com.fiap.projeto_redepapagaio.model.TipoAjuda;
import br.com.fiap.projeto_redepapagaio.repository.TipoAjudaRepository;
import br.com.fiap.projeto_redepapagaio.service.TipoAjudaCachingService;
import br.com.fiap.projeto_redepapagaio.service.TipoAjudaService;

@RestController
@RequestMapping("/tipos_ajudas")
public class TipoAjudaController {

	@Autowired
    private TipoAjudaRepository repTA;

    @Autowired
    private TipoAjudaCachingService cacheTA;

    @Autowired
    private TipoAjudaService servTA;

    @GetMapping("/todos")
    public List<TipoAjuda> listarTodosTipoAjudas() {
        return repTA.findAll();
    }

    @GetMapping("/todos_cacheable")
    public List<TipoAjuda> listarTodosTipoAjudasComCache() {
        return cacheTA.findAll();
    }

    @GetMapping("/paginados")
    public ResponseEntity<Page<TipoAjudaDTO>> paginar(
    		@RequestParam(value = "pagina", defaultValue = "0") Integer page,
			@RequestParam(value = "tamanho", defaultValue = "2") Integer size) {

        PageRequest req = PageRequest.of(page, size);
        Page<TipoAjudaDTO> paginas = servTA.paginar(req);

        return ResponseEntity.ok(paginas);
    }

    @GetMapping("/{id_tipo_ajuda}")
    public TipoAjuda buscarPorId(@PathVariable Long id_tipo_ajuda) {
        Optional<TipoAjuda> op = cacheTA.findById(id_tipo_ajuda);
        if (op.isPresent()) {
            return op.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/inserir")
    public TipoAjuda inserirTipoAjuda(@RequestBody TipoAjuda tipoAjuda) {
        repTA.save(tipoAjuda);
        cacheTA.limparCache();
        return tipoAjuda;
    }

    @PutMapping("/atualizar/{id_tipo_ajuda}")
    public TipoAjuda atualizarTipoAjuda(@RequestBody TipoAjuda tipoAjuda, @PathVariable Long id_tipo_ajuda) {
        Optional<TipoAjuda> op = cacheTA.findById(id_tipo_ajuda);

        if (op.isPresent()) {
        	TipoAjuda tipoAjudaAtual = op.get();
        	tipoAjudaAtual.setNmTipoAjuda(tipoAjuda.getNmTipoAjuda());
            repTA.save(tipoAjudaAtual);
            cacheTA.limparCache();
            return tipoAjudaAtual;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/remover/{id_tipo_ajuda}")
    public TipoAjuda removerTipoAjuda(@PathVariable Long id_tipo_ajuda) {
    	
        Optional<TipoAjuda> op = cacheTA.findById(id_tipo_ajuda);

        if (op.isPresent()) {
            TipoAjuda tipoAjuda = op.get();
            repTA.delete(tipoAjuda);
            cacheTA.limparCache();
            return tipoAjuda;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
