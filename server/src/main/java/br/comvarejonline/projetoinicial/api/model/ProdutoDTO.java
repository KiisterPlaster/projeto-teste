package br.comvarejonline.projetoinicial.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoDTO {
    private Long id;
    private String codigoBarra;
    private String nome;
    private Integer quantidadeMinima;
    private Integer saldoInicial;
}
