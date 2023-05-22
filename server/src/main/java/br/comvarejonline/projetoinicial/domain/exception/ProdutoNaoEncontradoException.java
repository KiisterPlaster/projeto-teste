package br.comvarejonline.projetoinicial.domain.exception;

public class ProdutoNaoEncontradoException extends EntidadeNaoEncontradaException {

    public static final String MSG_PRODUTO_NAO_ENCONTRADO = "Não existe um cadastro de produto com código %d";
    
    public ProdutoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public ProdutoNaoEncontradoException(Long produtoId) {
        this(String.format(MSG_PRODUTO_NAO_ENCONTRADO, produtoId));
    }
    

}