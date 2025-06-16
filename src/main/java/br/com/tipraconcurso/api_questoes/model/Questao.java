package br.com.tipraconcurso.api_questoes.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Table(name = "questoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Questao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String banca;

    @Column(nullable = false)
    private String orgao;

    @Column(nullable = false)
    private String ano;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String enunciado;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String alternativaA;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String alternativaB;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String alternativaC;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String alternativaD;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String alternativaE;

    @Column(nullable = false)
    private char gabarito;
    
}
