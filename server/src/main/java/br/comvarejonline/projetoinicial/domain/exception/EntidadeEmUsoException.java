package br.comvarejonline.projetoinicial.domain.exception;

public class EntidadeEmUsoException extends RuntimeException {
    
    public EntidadeEmUsoException(String mensagem) {
        super(mensagem);
    }
}
