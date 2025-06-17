package br.com.tipraconcurso.api_questoes.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestaoDTO {

    private Long id;
    private String banca;
    private String orgao;
    private String ano;
    //private String tipo;
    private String enunciado;
    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
    private String alternativaD;
    private String alternativaE;
    private char gabarito;

}
