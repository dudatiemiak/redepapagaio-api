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

import br.com.fiap.projeto_redepapagaio.dto.AjudaRealizadaDTO;
import br.com.fiap.projeto_redepapagaio.model.AjudaRealizada;
import br.com.fiap.projeto_redepapagaio.repository.AjudaRealizadaRepository;
import br.com.fiap.projeto_redepapagaio.service.AjudaRealizadaCachingService;
import br.com.fiap.projeto_redepapagaio.service.AjudaRealizadaService;

@RestController
@RequestMapping("/ajudas")
public class AjudaRealizadaController {

	@Autowired
    private AjudaRealizadaRepository repA;

    @Autowired
    private AjudaRealizadaCachingService cacheA;

    @Autowired
    private AjudaRealizadaService servA;

    @GetMapping("/todos")
    public List<AjudaRealizada> listarTodos() {
        return repA.findAll();
    }

    @GetMapping("/todos_cacheable")
    public List<AjudaRealizada> listarTodosComCache() {
        return cacheA.findAll();
    }

    @GetMapping("/ordenadas_por_data")
    public List<AjudaRealizada> listarOrdenadasPorData() {
        return repA.buscarAjudasOrdenadasPorData();
    }

    @GetMapping("/paginadas")
    public ResponseEntity<Page<AjudaRealizadaDTO>> paginar(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "5") int tamanho) {

        PageRequest pr = PageRequest.of(pagina, tamanho);
        Page<AjudaRealizadaDTO> paginas = servA.paginar(pr);

        return ResponseEntity.ok(paginas);
    }

    @GetMapping("/{id_ajuda}")
    public AjudaRealizada buscarPorId(@PathVariable Long id_ajuda) {
        Optional<AjudaRealizada> op = cacheA.findById(id_ajuda);
        if (op.isPresent()) {
            return op.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/inserir")
    public AjudaRealizada inserir(@RequestBody AjudaRealizada ajuda) {
        repA.save(ajuda);
        cacheA.limparCache();
        return ajuda;
    }

    @PutMapping("/atualizar/{id_ajuda}")
    public AjudaRealizada atualizar(@RequestBody AjudaRealizada ajuda, @PathVariable Long id_ajuda) {
        Optional<AjudaRealizada> op = cacheA.findById(id_ajuda);

        if (op.isPresent()) {
            AjudaRealizada ajudaAtual = op.get();

            ajudaAtual.setUsuario(ajuda.getUsuario());
            ajudaAtual.setOcorrencia(ajuda.getOcorrencia());
            ajudaAtual.setTipoAjuda(ajuda.getTipoAjuda());
            ajudaAtual.setDsAjuda(ajuda.getDsAjuda());
            ajudaAtual.setDtAjuda(ajuda.getDtAjuda());

            repA.save(ajudaAtual);
            cacheA.limparCache();

            return ajudaAtual;

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/remover/{id_ajuda}")
    public AjudaRealizada remover(@PathVariable Long id_ajuda) {
        Optional<AjudaRealizada> op = cacheA.findById(id_ajuda);

        if (op.isPresent()) {
            AjudaRealizada ajuda = op.get();
            repA.delete(ajuda);
            cacheA.limparCache();
            return ajuda;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
