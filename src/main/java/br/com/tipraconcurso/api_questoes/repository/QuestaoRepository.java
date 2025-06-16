package br.com.tipraconcurso.api_questoes.repository;

import br.com.tipraconcurso.api_questoes.model.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Long> {

    // Aqui você pode adicionar métodos personalizados de consulta, se necessário.
    // Por exemplo, para buscar questões por banca ou órgão:
    // List<Questao> findByBanca(String banca);
    // List<Questao> findByOrgao(String orgao);
}
