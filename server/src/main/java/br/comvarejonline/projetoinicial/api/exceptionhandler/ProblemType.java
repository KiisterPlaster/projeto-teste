package br.comvarejonline.projetoinicial.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos"),
    ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
    PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
    ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio"), 
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado");

    private final String title;
    private final String uri;

    ProblemType(String path, String title) {
        this.uri = "projeto-api.com.br" + path;
        this.title = title;
    }

}