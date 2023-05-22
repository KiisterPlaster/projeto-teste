package br.comvarejonline.projetoinicial.domain.service;

import br.comvarejonline.projetoinicial.domain.exception.PermissaoNaoEncontradaException;
import br.comvarejonline.projetoinicial.domain.model.Permissao;
import br.comvarejonline.projetoinicial.domain.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroPermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;
    
    public Permissao buscarOuFalhar(Long permissaoId) {
        return permissaoRepository.findById(permissaoId)
                .orElseThrow(() -> new PermissaoNaoEncontradaException(permissaoId));
    }
}
