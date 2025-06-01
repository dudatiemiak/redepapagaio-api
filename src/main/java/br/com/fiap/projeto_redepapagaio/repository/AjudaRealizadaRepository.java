package br.com.fiap.projeto_redepapagaio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.projeto_redepapagaio.model.AjudaRealizada;

public interface AjudaRealizadaRepository extends JpaRepository<AjudaRealizada, Long>{

	// Busca todas as ajudas realizadas ordenadas pela data (mais recente primeiro)
    @Query(nativeQuery = true, value = """
        SELECT * FROM t_ppg_ajuda_realizada
        ORDER BY dt_ajuda DESC
    """)
    List<AjudaRealizada> buscarAjudasOrdenadasPorData();
}
