package br.comvarejonline.projetoinicial.api.model.input;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoInput {
    
    private String nome;
    
    private Integer quantidadeMinima;

    private Integer saldoInicial;

}  
