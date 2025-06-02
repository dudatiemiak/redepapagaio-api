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

import br.com.fiap.projeto_redepapagaio.dto.OcorrenciaDTO;
import br.com.fiap.projeto_redepapagaio.model.Ocorrencia;
import br.com.fiap.projeto_redepapagaio.repository.OcorrenciaRepository;
import br.com.fiap.projeto_redepapagaio.service.OcorrenciaCachingService;
import br.com.fiap.projeto_redepapagaio.service.OcorrenciaService;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

	@Autowired
    private OcorrenciaRepository repO;

    @Autowired
    private OcorrenciaCachingService cacheO;

    @Autowired
    private OcorrenciaService servO;

    @GetMapping("/todas")
    public List<Ocorrencia> listarTodasOcorrencias() {
        return repO.findAll();
    }

    @GetMapping("/todas_cacheable")
    public List<Ocorrencia> listarTodasOcorrenciasComCache() {
        return cacheO.findAll();
    }

    @GetMapping("/paginadas")
    public ResponseEntity<Page<OcorrenciaDTO>> paginar(
    		@RequestParam(value = "pagina", defaultValue = "0") Integer page,
			@RequestParam(value = "tamanho", defaultValue = "2") Integer size) {

        PageRequest req = PageRequest.of(page, size);
        Page<OcorrenciaDTO> paginas = servO.paginar(req);

        return ResponseEntity.ok(paginas);
    }

    @GetMapping("/{id_ocorrencia}")
    public Ocorrencia buscarPorId(@PathVariable Long id_ocorrencia) {
        Optional<Ocorrencia> op = cacheO.findById(id_ocorrencia);
        if (op.isPresent()) {
            return op.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/inserir")
    public Ocorrencia inserirOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        repO.save(ocorrencia);
        cacheO.limparCache();
        return ocorrencia;
    }

    @PutMapping("/atualizar/{id_ocorrencia}")
    public Ocorrencia atualizar(@RequestBody Ocorrencia ocorrencia, @PathVariable Long id_ocorrencia) {
        Optional<Ocorrencia> op = cacheO.findById(id_ocorrencia);

        if (op.isPresent()) {
            Ocorrencia ocorrenciaAtual = op.get();

            ocorrenciaAtual.setStatusOcorrencia(ocorrencia.getStatusOcorrencia());
            ocorrenciaAtual.setNivelUrgencia(ocorrencia.getNivelUrgencia());
            ocorrenciaAtual.setRegiao(ocorrencia.getRegiao());
            ocorrenciaAtual.setTipoOcorrencia(ocorrencia.getTipoOcorrencia());
            ocorrenciaAtual.setDsOcorrencia(ocorrencia.getDsOcorrencia());

            repO.save(ocorrenciaAtual);
            cacheO.limparCache();

            return ocorrenciaAtual;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/remover/{id_ocorrencia}")
    public Ocorrencia removerOcorrencia(@PathVariable Long id_ocorrencia) {
        Optional<Ocorrencia> op = cacheO.findById(id_ocorrencia);

        if (op.isPresent()) {
            Ocorrencia ocorrencia = op.get();
            repO.delete(ocorrencia);
            cacheO.limparCache();
            return ocorrencia;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscar_por_regiao")
    public ResponseEntity<List<Ocorrencia>> buscarOcorrenciaPorRegiao(@RequestParam Long idRegiao) {
        List<Ocorrencia> lista = repO.buscarPorRegiao(idRegiao);
        if (lista.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar_por_urgencia")
    public ResponseEntity<List<Ocorrencia>> buscarOcorrenciaPorUrgencia(@RequestParam Long idUrgencia) {
        List<Ocorrencia> lista = repO.buscarPorUrgencia(idUrgencia);
        if (lista.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar_por_status")
    public ResponseEntity<List<Ocorrencia>> buscarOcorrenciaPorStatus(@RequestParam Long idStatus) {
        List<Ocorrencia> lista = repO.buscarPorStatus(idStatus);
        if (lista.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar_por_tipo")
    public ResponseEntity<List<Ocorrencia>> buscarOcorrenciaPorTipo(@RequestParam Long idTipo) {
        List<Ocorrencia> lista = repO.buscarPorTipo(idTipo);
        if (lista.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar_por_descricao")
    public ResponseEntity<List<Ocorrencia>> buscarOcorrenciaPorDescricao(@RequestParam String termo) {
        List<Ocorrencia> lista = repO.buscarPorDescricaoContendo(termo);
        if (lista.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(lista);
    }
}
