package br.comvarejonline.projetoinicial.api.assembler;

import br.comvarejonline.projetoinicial.api.model.GrupoDTO;
import br.comvarejonline.projetoinicial.domain.model.Grupo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GrupoModelAssembler {
    
    @Autowired
    private ModelMapper modelMapper;
    
    public GrupoDTO toModel(Grupo grupo) {
        return modelMapper.map(grupo, GrupoDTO.class);
    }

    public List<GrupoDTO> toCollectionModel(Collection<Grupo> grupos) {
        return grupos.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
