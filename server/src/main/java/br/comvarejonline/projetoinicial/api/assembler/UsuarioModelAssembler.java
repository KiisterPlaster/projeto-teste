package br.comvarejonline.projetoinicial.api.assembler;

import br.comvarejonline.projetoinicial.api.model.UsuarioDTO;
import br.comvarejonline.projetoinicial.domain.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioModelAssembler {
    
    @Autowired
    private ModelMapper modelMapper;
    
    public UsuarioDTO toModel(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    public List<UsuarioDTO> toCollectionModel(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
