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

import br.com.fiap.projeto_redepapagaio.dto.StatusOcorrenciaDTO;
import br.com.fiap.projeto_redepapagaio.model.StatusOcorrencia;
import br.com.fiap.projeto_redepapagaio.repository.StatusOcorrenciaRepository;
import br.com.fiap.projeto_redepapagaio.service.StatusOcorrenciaCachingService;
import br.com.fiap.projeto_redepapagaio.service.StatusOcorrenciaService;

public class StatusOcorrenciaController {

	@Autowired
    private StatusOcorrenciaRepository repS;

    @Autowired
    private StatusOcorrenciaCachingService cacheS;

    @Autowired
    private StatusOcorrenciaService servS;

    @GetMapping("/todos")
    public List<StatusOcorrencia> listarTodosStatusOcorrencias() {
        return repS.findAll();
    }

    @GetMapping("/todos_cacheable")
    public List<StatusOcorrencia> listarTodosStatusOcorrenciasComCache() {
        return cacheS.findAll();
    }

    @GetMapping("/paginados")
    public ResponseEntity<Page<StatusOcorrenciaDTO>> paginar(
    		@RequestParam(value = "pagina", defaultValue = "0") Integer page,
			@RequestParam(value = "tamanho", defaultValue = "2") Integer size) {

        PageRequest req = PageRequest.of(page, size);
        Page<StatusOcorrenciaDTO> paginas = servS.paginar(req);

        return ResponseEntity.ok(paginas);
    }

    @GetMapping("/{id_status_ocorrencia}")
    public StatusOcorrencia buscarPorId(@PathVariable Long id_status_ocorrencia) {
        Optional<StatusOcorrencia> op = cacheS.findById(id_status_ocorrencia);
        if (op.isPresent()) {
            return op.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/inserir")
    public StatusOcorrencia inserirStatusOcorrencia(@RequestBody StatusOcorrencia status) {
    	repS.save(status);
    	cacheS.limparCache();
        return status;
    }

    @PutMapping("/atualizar/{id_status_ocorrencia}")
    public StatusOcorrencia atualizarStatusOcorrencia(@RequestBody StatusOcorrencia status, @PathVariable Long id_status_ocorrencia) {
        Optional<StatusOcorrencia> op = cacheS.findById(id_status_ocorrencia);

        if (op.isPresent()) {
        	StatusOcorrencia statusAtual = op.get();
        	statusAtual.setNmStatus(status.getNmStatus());
            repS.save(statusAtual);
            cacheS.limparCache();
            return statusAtual;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/remover/{id_status_ocorrencia}")
    public StatusOcorrencia removerStatusOcorrencia(@PathVariable Long id_status_ocorrencia) {
    	
        Optional<StatusOcorrencia> op = cacheS.findById(id_status_ocorrencia);

        if (op.isPresent()) {
        	StatusOcorrencia status = op.get();
            repS.delete(status);
            cacheS.limparCache();
            return status;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
