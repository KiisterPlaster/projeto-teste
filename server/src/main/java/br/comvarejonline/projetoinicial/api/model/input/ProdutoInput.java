package br.comvarejonline.projetoinicial.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Setter
@Getter
public class ProdutoInput {
    
    @NotBlank
    private String nome;
    
    @NotNull
    @PositiveOrZero
    private Integer quantidadeMinima;

    @NotNull
    @PositiveOrZero
    private Integer saldoInicial;

}  
