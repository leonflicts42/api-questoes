package br.com.tipraconcurso.api_questoes.service;

import br.com.tipraconcurso.api_questoes.dto.QuestaoDTO;
import br.com.tipraconcurso.api_questoes.model.Questao;
import br.com.tipraconcurso.api_questoes.repository.QuestaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository questaoRepository;

    //Criar uma nova questão
    public QuestaoDTO criarQuestao(QuestaoDTO questaoDTO) {
        Questao questao = new Questao();
        BeanUtils.copyProperties(questaoDTO, questao);
        Questao questaoSalva = questaoRepository.save(questao);
        BeanUtils.copyProperties(questaoSalva, questaoDTO);
        return questaoDTO;

    }

    //Listar todas as questões
    public List<QuestaoDTO> listarTodas(){
        return questaoRepository.findAll()
            .stream()
            .map(this::converterParaDTO)
            .collect(Collectors.toList());
    }

    //Listar questões por ID
    public Optional<QuestaoDTO> buscarPorId(Long id){
        return questaoRepository.findById(id).map(this::converterParaDTO);
    }

    //Atualizar uma questão
    public Optional<QuestaoDTO> atualizarQuestao(Long id, QuestaoDTO questaoDTO){
        return questaoRepository.findById(id).map(questaoExistente -> {
            BeanUtils.copyProperties(questaoDTO, questaoExistente, "id");
            Questao questaoAtualizada = questaoRepository.save(questaoExistente);
            return converterParaDTO(questaoAtualizada);
        });
    }

    //Deletar uma questão
    public boolean deletarQuestao(Long id){
        if(questaoRepository.existsById(id)){
            questaoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //Metodo auxiliar para converter Questao para QuestaoDTO
    private QuestaoDTO converterParaDTO(Questao questao){
        QuestaoDTO questaoDTO = new QuestaoDTO();
        BeanUtils.copyProperties(questao, questaoDTO);
        return questaoDTO;
    }
}