package br.comvarejonline.projetoinicial.domain.service;

import br.comvarejonline.projetoinicial.domain.exception.ProdutoNaoEncontradoException;
import br.comvarejonline.projetoinicial.domain.model.Produto;
import br.comvarejonline.projetoinicial.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Transactional
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto buscarOuFalhar(Long produtoId) {
        return produtoRepository.findById(produtoId)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(produtoId));
    }
}
