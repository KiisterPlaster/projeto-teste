package br.comvarejonline.projetoinicial.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class UsuarioLoginDTO {
    
    private Long id;

    private String nome;

    private String email;
    
    private String senha;

    private String token;
    
    private String grupos;
    
    }
