package br.comvarejonline.projetoinicial.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_de_barra")
    private String codigoBarra;

    @Column(nullable = false)
    private String nome;
    
    @Column(name = "quantidade_minima", nullable = false)
    private Integer quantidadeMinima;
    
    @Column(name = "saldo_inicial")
    private Integer saldoInicial;
    
    private void gerarCodigo() { setCodigoBarra(UUID.randomUUID().toString()); }
}
