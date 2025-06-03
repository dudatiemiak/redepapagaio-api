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

import br.com.fiap.projeto_redepapagaio.dto.TelefoneDTO;
import br.com.fiap.projeto_redepapagaio.model.Telefone;
import br.com.fiap.projeto_redepapagaio.repository.TelefoneRepository;
import br.com.fiap.projeto_redepapagaio.service.TelefoneCachingService;
import br.com.fiap.projeto_redepapagaio.service.TelefoneService;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

	@Autowired
    private TelefoneRepository repT;

    @Autowired
    private TelefoneCachingService cacheT;

    @Autowired
    private TelefoneService servT;

    @GetMapping("/todos")
    public List<Telefone> listarTodosTelefones() {
        return repT.findAll();
    }

    @GetMapping("/todos_cacheable")
    public List<Telefone> listarTodosTelefonesComCache() {
        return cacheT.findAll();
    }

    @GetMapping("/paginados")
    public ResponseEntity<Page<TelefoneDTO>> paginar(
    		@RequestParam(value = "pagina", defaultValue = "0") Integer page,
			@RequestParam(value = "tamanho", defaultValue = "2") Integer size) {

        PageRequest req = PageRequest.of(page, size);
        Page<TelefoneDTO> paginas = servT.paginar(req);

        return ResponseEntity.ok(paginas);
    }

    @GetMapping("/{id_telefone}")
    public Telefone buscarPorId(@PathVariable Long id_telefone) {
        Optional<Telefone> op = cacheT.findById(id_telefone);
        if (op.isPresent()) {
            return op.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/inserir")
    public Telefone inserirTelefone(@RequestBody Telefone telefone) {
        repT.save(telefone);
        cacheT.limparCache();
        return telefone;
    }

    @PutMapping("/atualizar/{id_telefone}")
    public Telefone atualizarTelefone(@RequestBody Telefone telefone, @PathVariable Long id_telefone) {
        Optional<Telefone> op = cacheT.findById(id_telefone);

        if (op.isPresent()) {
        	Telefone telefoneAtual = op.get();
        	telefoneAtual.setUsuario(telefone.getUsuario());
        	telefoneAtual.setNrTelefone(telefone.getNrTelefone());
        	telefoneAtual.setNrDDD(telefone.getNrDDD());
        	telefoneAtual.setNrDDI(telefone.getNrDDI());
            repT.save(telefoneAtual);
            cacheT.limparCache();
            return telefoneAtual;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/remover/{id_telefone}")
    public Telefone removerTelefone(@PathVariable Long id_telefone) {
    	
        Optional<Telefone> op = cacheT.findById(id_telefone);

        if (op.isPresent()) {
        	Telefone telefone = op.get();
            repT.delete(telefone);
            cacheT.limparCache();
            return telefone;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
