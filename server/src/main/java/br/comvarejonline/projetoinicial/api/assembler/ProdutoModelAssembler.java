package br.comvarejonline.projetoinicial.api.assembler;

import br.comvarejonline.projetoinicial.api.model.view.ProdutoDTO;
import br.comvarejonline.projetoinicial.domain.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoModelAssembler {
    
    @Autowired
    private ModelMapper modelMapper;
    
    public ProdutoDTO toModel(Produto produto) {
        return modelMapper.map(produto, ProdutoDTO.class);
    }

    public List<ProdutoDTO> toCollectionModel(List<Produto> produtos) {
        return produtos.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
