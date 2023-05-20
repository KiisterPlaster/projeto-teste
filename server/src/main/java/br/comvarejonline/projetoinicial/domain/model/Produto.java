package br.comvarejonline.projetoinicial.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_de_barra",unique = true)
    private String codigoBarra;

    @Column(nullable = false)
    private String nome;
    
    @Column(name = "quantidade_minima", nullable = false)
    private Integer quantidadeMinima;
    
    @Column(name = "saldo_inicial")
    private Integer saldoInicial;
}
