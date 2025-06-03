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

import br.com.fiap.projeto_redepapagaio.dto.RegiaoDTO;
import br.com.fiap.projeto_redepapagaio.model.Regiao;
import br.com.fiap.projeto_redepapagaio.repository.RegiaoRepository;
import br.com.fiap.projeto_redepapagaio.service.RegiaoCachingService;
import br.com.fiap.projeto_redepapagaio.service.RegiaoService;

@RestController
@RequestMapping("/regioes")
public class RegiaoController {

	@Autowired
    private RegiaoRepository repR;

    @Autowired
    private RegiaoCachingService cacheR;

    @Autowired
    private RegiaoService servR;

    @GetMapping("/todas")
    public List<Regiao> listarTodasRegioes() {
        return repR.findAll();
    }

    @GetMapping("/todas_cacheable")
    public List<Regiao> listarTodasRegioesComCache() {
        return cacheR.findAll();
    }

    @GetMapping("/paginados")
    public ResponseEntity<Page<RegiaoDTO>> paginar(
    		@RequestParam(value = "pagina", defaultValue = "0") Integer page,
			@RequestParam(value = "tamanho", defaultValue = "2") Integer size) {

        PageRequest req = PageRequest.of(page, size);
        Page<RegiaoDTO> paginas = servR.paginar(req);

        return ResponseEntity.ok(paginas);
    }

    @GetMapping("/{id_regiao}")
    public Regiao buscarPorId(@PathVariable Long id_regiao) {
        Optional<Regiao> op = cacheR.findById(id_regiao);
        if (op.isPresent()) {
            return op.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/inserir")
    public Regiao inserirRegiao(@RequestBody Regiao regiao) {
        repR.save(regiao);
        cacheR.limparCache();
        return regiao;
    }

    @PutMapping("/atualizar/{id_nivel}")
    public Regiao atualizarRegiao(@RequestBody Regiao regiao, @PathVariable Long id_regiao) {
        Optional<Regiao> op = cacheR.findById(id_regiao);

        if (op.isPresent()) {
            Regiao regiaoAtual = op.get();
            regiaoAtual.setNmRegiao(regiao.getNmRegiao());
            regiaoAtual.setNmCidade(regiao.getNmCidade());
            regiaoAtual.setNmEstado(regiao.getNmEstado());
            repR.save(regiaoAtual);
            cacheR.limparCache();
            return regiaoAtual;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/remover/{id_regiao}")
    public Regiao removerRegiao(@PathVariable Long id_regiao) {
    	
        Optional<Regiao> op = cacheR.findById(id_regiao);

        if (op.isPresent()) {
        	Regiao regiao = op.get();
            repR.delete(regiao);
            cacheR.limparCache();
            return regiao;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
