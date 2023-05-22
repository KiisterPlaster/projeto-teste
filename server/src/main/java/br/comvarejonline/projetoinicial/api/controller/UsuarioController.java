package br.comvarejonline.projetoinicial.api.controller;

import br.comvarejonline.projetoinicial.api.assembler.UsuarioInputDisassembler;
import br.comvarejonline.projetoinicial.api.assembler.UsuarioModelAssembler;
import br.comvarejonline.projetoinicial.api.model.input.SenhaInput;
import br.comvarejonline.projetoinicial.api.model.input.UsuarioComSenhaInput;
import br.comvarejonline.projetoinicial.api.model.input.UsuarioInput;
import br.comvarejonline.projetoinicial.api.model.UsuarioDTO;
import br.comvarejonline.projetoinicial.api.model.view.GrupoView;
import br.comvarejonline.projetoinicial.domain.model.Usuario;
import br.comvarejonline.projetoinicial.domain.repository.UsuarioRepository;
import br.comvarejonline.projetoinicial.domain.service.CadastroUsuarioService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioModelAssembler usuarioModelAssembler;

	@Autowired
	private UsuarioInputDisassembler usuarioInputDisassembler;

	@Autowired
	private CadastroUsuarioService cadastroUsuario;

	@GetMapping
	public List<UsuarioDTO> listar() { return usuarioModelAssembler.toCollectionModel(usuarioRepository.findAll()); }

	@GetMapping("/{usuarioId}")
	public UsuarioDTO buscar(@PathVariable Long usuarioId){

		Usuario usuario = cadastroUsuario.buscarOuFalhar(usuarioId);

		return usuarioModelAssembler.toModel(usuario);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioDTO adicionar(@RequestBody UsuarioComSenhaInput usuarioInput) {
		Usuario usuario = usuarioInputDisassembler.toDomainObject(usuarioInput);

		return usuarioModelAssembler.toModel(cadastroUsuario.salvar(usuario));
	}

	@PutMapping("/{usuarioId}")
	public UsuarioDTO atualizar(@PathVariable Long usuarioId,
								@RequestBody @Valid UsuarioInput usuarioInput) {

		Usuario usuarioAtual = cadastroUsuario.buscarOuFalhar(usuarioId);

		usuarioInputDisassembler.copyToDomainObject(usuarioInput, usuarioAtual);

		return usuarioModelAssembler.toModel(cadastroUsuario.salvar(usuarioAtual));
	}

	@PutMapping("/{usuarioId}/senha")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterarSenha(@PathVariable Long usuarioId, @RequestBody SenhaInput senha) {
		cadastroUsuario.alterarSenha(usuarioId, senha.getSenhaAtual(), senha.getNovaSenha());
	}
	
}
