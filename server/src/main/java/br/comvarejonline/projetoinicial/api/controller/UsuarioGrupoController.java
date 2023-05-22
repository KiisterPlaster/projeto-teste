package br.comvarejonline.projetoinicial.api.controller;

import br.comvarejonline.projetoinicial.api.assembler.GrupoModelAssembler;
import br.comvarejonline.projetoinicial.api.model.GrupoDTO;
import br.comvarejonline.projetoinicial.domain.model.Usuario;
import br.comvarejonline.projetoinicial.domain.service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios/{usuarioId}/grupos")
public class UsuarioGrupoController {
    
  
    @Autowired
    private CadastroUsuarioService cadastroUsuario;
    
    @Autowired
    private GrupoModelAssembler grupoModelAssembler;
    
    
    @GetMapping
    public List<GrupoDTO> listar(@PathVariable Long usuarioId) {
        Usuario usuario = cadastroUsuario.buscarOuFalhar(usuarioId);
        
        return grupoModelAssembler.toCollectionModel(usuario.getGrupos());
    }

    @DeleteMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociar(@PathVariable Long usuarioId, @PathVariable Long grupoId){
        cadastroUsuario.desassociarGrupo(usuarioId, grupoId);
    }

    @PutMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associar(@PathVariable Long usuarioId, @PathVariable Long grupoId){
        cadastroUsuario.associarGrupo(usuarioId, grupoId);
    }
}
