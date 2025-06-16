package br.com.tipraconcurso.api_questoes.controller;

import br.com.tipraconcurso.api_questoes.dto.QuestaoDTO;
import br.com.tipraconcurso.api_questoes.service.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-questoes") // Prefixo para todos os endpoints desta controller
public class QuestaoController {

    @Autowired
    private QuestaoService questaoService;

    // Endpoint para criar uma nova questão
    @PostMapping("/api-questoes")
    public ResponseEntity<QuestaoDTO> criarQuestao(@RequestBody QuestaoDTO questaoDTO){
        QuestaoDTO novaQuestao = questaoService.criarQuestao(questaoDTO);
        return new ResponseEntity<>(novaQuestao, HttpStatus.CREATED);
    }

    // Endpoint para listar todas as questões
    @GetMapping("/api-questoes")
    public ResponseEntity<List<QuestaoDTO>> listarTodasAsQuestoes(){
        List<QuestaoDTO> questoes = questaoService.listarTodas();
        return ResponseEntity.ok(questoes);
    }

    // Endpoint para buscar uma questão por ID
    @GetMapping("/{id}")
    public ResponseEntity<QuestaoDTO> buscarQuestaoPorID(@PathVariable long id){
        return questaoService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para atualizar uma questão
    @PutMapping("/{id}")
    public ResponseEntity<QuestaoDTO> atualizarQuestao(@PathVariable Long id, @RequestBody QuestaoDTO questaoDTO){
        return questaoService.atualizarQuestao(id, questaoDTO)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para deletar uma questão
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarQuestao(@PathVariable Long id){
        if(questaoService.deletarQuestao(id)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();   
        }
    }
}
