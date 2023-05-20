package br.comvarejonline.projetoinicial.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Permissao {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;
}
