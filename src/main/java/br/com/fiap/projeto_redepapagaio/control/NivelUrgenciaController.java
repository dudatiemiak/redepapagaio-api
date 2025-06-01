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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.projeto_redepapagaio.dto.NivelUrgenciaDTO;
import br.com.fiap.projeto_redepapagaio.model.NivelUrgencia;
import br.com.fiap.projeto_redepapagaio.repository.NivelUrgenciaRepository;
import br.com.fiap.projeto_redepapagaio.service.NivelUrgenciaCachingService;
import br.com.fiap.projeto_redepapagaio.service.NivelUrgenciaService;

public class NivelUrgenciaController {

	@Autowired
    private NivelUrgenciaRepository repN;

    @Autowired
    private NivelUrgenciaCachingService cacheN;

    @Autowired
    private NivelUrgenciaService servN;

    @GetMapping("/todos")
    public List<NivelUrgencia> listarTodosNiveisUrgencias() {
        return repN.findAll();
    }

    @GetMapping("/todos_cacheable")
    public List<NivelUrgencia> listarTodosNiveisUrgenciasComCache() {
        return cacheN.findAll();
    }

    @GetMapping("/paginados")
    public ResponseEntity<Page<NivelUrgenciaDTO>> paginar(
    		@RequestParam(value = "pagina", defaultValue = "0") Integer page,
			@RequestParam(value = "tamanho", defaultValue = "2") Integer size) {

        PageRequest req = PageRequest.of(page, size);
        Page<NivelUrgenciaDTO> paginas = servN.paginar(req);

        return ResponseEntity.ok(paginas);
    }

    @GetMapping("/{id_nivel}")
    public NivelUrgencia buscarPorId(@PathVariable Long id_nivel) {
        Optional<NivelUrgencia> op = cacheN.findById(id_nivel);
        if (op.isPresent()) {
            return op.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/inserir")
    public NivelUrgencia inserirNivelUrgencia(@RequestBody NivelUrgencia nivelUrgencia) {
        repN.save(nivelUrgencia);
        cacheN.limparCache();
        return nivelUrgencia;
    }

    @PutMapping("/atualizar/{id_nivel}")
    public NivelUrgencia atualizarNivelUrgencia(@RequestBody NivelUrgencia nivelUrgencia, @PathVariable Long id_nivel) {
        Optional<NivelUrgencia> op = cacheN.findById(id_nivel);

        if (op.isPresent()) {
            NivelUrgencia nivelAtual = op.get();
            nivelAtual.setNmNivel(nivelUrgencia.getNmNivel());
            repN.save(nivelAtual);
            cacheN.limparCache();
            return nivelAtual;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/remover/{id_nivel}")
    public NivelUrgencia removerNivelUrgencia(@PathVariable Long id_nivel) {
    	
        Optional<NivelUrgencia> op = cacheN.findById(id_nivel);

        if (op.isPresent()) {
            NivelUrgencia nivel = op.get();
            repN.delete(nivel);
            cacheN.limparCache();
            return nivel;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
