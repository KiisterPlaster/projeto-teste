package br.comvarejonline.projetoinicial.domain.exception;

public class PermissaoNaoEncontradaException extends EntidadeNaoEncontradaException {
    
    public PermissaoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public PermissaoNaoEncontradaException(Long permissaoId) {
        this(String.format("Não existe um cadastro de uma permissão com código %d", permissaoId));
    }

}