package br.comvarejonline.projetoinicial.domain.exception;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {

    public static final String MSG_USUARIO_NAO_ENCONTRADO = "Não existe um cadastro de usuário com código %d";

    public UsuarioNaoEncontradoException(String mensagem) {
        super( mensagem);
    }

    public UsuarioNaoEncontradoException(Long usuarioId) {
        this(String.format(MSG_USUARIO_NAO_ENCONTRADO, usuarioId));
    }

}