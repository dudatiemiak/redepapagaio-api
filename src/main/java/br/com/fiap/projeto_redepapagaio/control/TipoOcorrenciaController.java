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

import br.com.fiap.projeto_redepapagaio.dto.TipoOcorrenciaDTO;
import br.com.fiap.projeto_redepapagaio.model.TipoOcorrencia;
import br.com.fiap.projeto_redepapagaio.repository.TipoOcorrenciaRepository;
import br.com.fiap.projeto_redepapagaio.service.TipoOcorrenciaCachingService;
import br.com.fiap.projeto_redepapagaio.service.TipoOcorrenciaService;

@RestController
@RequestMapping("/tipos_ocorrencias")
public class TipoOcorrenciaController {

	@Autowired
    private TipoOcorrenciaRepository repTO;

    @Autowired
    private TipoOcorrenciaCachingService cacheTO;

    @Autowired
    private TipoOcorrenciaService servTO;

    @GetMapping("/todos")
    public List<TipoOcorrencia> listarTodosTiposOcorrencias() {
        return repTO.findAll();
    }

    @GetMapping("/todos_cacheable")
    public List<TipoOcorrencia> listarTodosTiposOcorrenciasComCache() {
        return cacheTO.findAll();
    }

    @GetMapping("/paginados")
    public ResponseEntity<Page<TipoOcorrenciaDTO>> paginar(
    		@RequestParam(value = "pagina", defaultValue = "0") Integer page,
			@RequestParam(value = "tamanho", defaultValue = "2") Integer size) {

        PageRequest req = PageRequest.of(page, size);
        Page<TipoOcorrenciaDTO> paginas = servTO.paginar(req);

        return ResponseEntity.ok(paginas);
    }

    @GetMapping("/{id_tipo_ocorrencia}")
    public TipoOcorrencia buscarPorId(@PathVariable Long id_tipo_ocorrencia) {
        Optional<TipoOcorrencia> op = cacheTO.findById(id_tipo_ocorrencia);
        if (op.isPresent()) {
            return op.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/inserir")
    public TipoOcorrencia inserirTipoOcorrencia(@RequestBody TipoOcorrencia tipoOcorrencia) {
        repTO.save(tipoOcorrencia);
        cacheTO.limparCache();
        return tipoOcorrencia;
    }

    @PutMapping("/atualizar/{id_tipo_ocorrencia}")
    public TipoOcorrencia atualizarTipoOcorrencia(@RequestBody TipoOcorrencia tipoOcorrencia, @PathVariable Long id_tipo_ocorrencia) {
        Optional<TipoOcorrencia> op = cacheTO.findById(id_tipo_ocorrencia);

        if (op.isPresent()) {
        	TipoOcorrencia tipoOcorrenciaAtual = op.get();
        	tipoOcorrenciaAtual.setNmTipoOcorrencia(tipoOcorrencia.getNmTipoOcorrencia());
            repTO.save(tipoOcorrenciaAtual);
            cacheTO.limparCache();
            return tipoOcorrenciaAtual;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/remover/{id_tipo_ocorrencia}")
    public TipoOcorrencia removerTipoOcorrencia(@PathVariable Long id_tipo_ocorrencia) {
    	
        Optional<TipoOcorrencia> op = cacheTO.findById(id_tipo_ocorrencia);

        if (op.isPresent()) {
        	TipoOcorrencia tipoOcorrencia = op.get();
            repTO.delete(tipoOcorrencia);
            cacheTO.limparCache();
            return tipoOcorrencia;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
