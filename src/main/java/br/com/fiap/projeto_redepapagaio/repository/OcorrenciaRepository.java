package br.com.fiap.projeto_redepapagaio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.projeto_redepapagaio.model.Ocorrencia;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long>{

	//Busca ocorrência por região e ordem por ordem alfabética por descrição da ocorrência
	@Query(nativeQuery = true, value = """
		SELECT * FROM t_ppg_ocorrencia
		WHERE id_regiao = :idRegiao
		ORDER BY ds_ocorrencia ASC
	""")
	List<Ocorrencia> buscarPorRegiao(Long idRegiao);

    //Busca ocorrência por nível de urgência e ordena por região (ordem alfabética)
    @Query(nativeQuery = true, value = """
        SELECT * FROM t_ppg_ocorrencia
        WHERE id_nivel_urgencia = :idUrgencia
        ORDER BY id_regiao ASC
    """)
    List<Ocorrencia> buscarPorUrgencia(Long idUrgencia);

    //Busca ocorrência por status da ocorrência e ordena por região (ordem alfabética)
    @Query(nativeQuery = true, value = """
        SELECT * FROM t_ppg_ocorrencia
        WHERE id_status_ocorrencia = :idStatus
        ORDER BY id_regiao ASC
    """)
    List<Ocorrencia> buscarPorStatus(Long idStatus);

    //Busca ocorrência por tipo de ocorrência e ordena por região (ordem alfabética)
    @Query(nativeQuery = true, value = """
        SELECT * FROM t_ppg_ocorrencia
        WHERE id_tipo_ocorrencia = :idTipo
        ORDER BY id_regiao ASC
    """)
    List<Ocorrencia> buscarPorTipo(Long idTipo);

    //Busca ocorrência por parte da descrição
    @Query(nativeQuery = true, value = """
        SELECT * FROM t_ppg_ocorrencia
        WHERE LOWER(ds_ocorrencia) LIKE LOWER(CONCAT('%', :termo, '%'))
    """)
    List<Ocorrencia> buscarPorDescricaoContendo(String termo);

}
