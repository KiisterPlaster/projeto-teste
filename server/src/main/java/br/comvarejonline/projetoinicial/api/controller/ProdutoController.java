package br.comvarejonline.projetoinicial.api.controller;

import br.comvarejonline.projetoinicial.api.assembler.ProdutoInputDisassembler;
import br.comvarejonline.projetoinicial.api.assembler.ProdutoModelAssembler;
import br.comvarejonline.projetoinicial.api.model.input.ProdutoInput;
import br.comvarejonline.projetoinicial.api.model.ProdutoDTO;
import br.comvarejonline.projetoinicial.domain.exception.NegocioException;
import br.comvarejonline.projetoinicial.domain.exception.UsuarioNaoEncontradoException;
import br.comvarejonline.projetoinicial.domain.model.Produto;
import br.comvarejonline.projetoinicial.domain.model.Usuario;
import br.comvarejonline.projetoinicial.domain.repository.ProdutoRepository;
import br.comvarejonline.projetoinicial.domain.repository.UsuarioRepository;
import br.comvarejonline.projetoinicial.domain.service.CadastroProdutoService;
import br.comvarejonline.projetoinicial.domain.service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario/{usuarioId}/produtos")
public class ProdutoController {
	
	@Autowired
	private CadastroProdutoService cadastroProduto;
	
	@Autowired
	private CadastroUsuarioService cadastroUsuario;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ProdutoInputDisassembler produtoInputDisassembler;
	
	@Autowired
	private ProdutoModelAssembler produtoModelAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProdutoDTO adicionar(@PathVariable Long usuarioId,@RequestBody @Valid ProdutoInput produtoInput) {
		try{
			Usuario usuario = cadastroUsuario.buscarOuFalhar(usuarioId);
			
			Produto produto = produtoInputDisassembler.toDomainObject(produtoInput);
			
			return produtoModelAssembler.toModel(cadastroProduto.salvar(produto));
		} catch (UsuarioNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@GetMapping
	public List<Produto> listarProduto() {
		return produtoRepository.findAll();
	}
	
}
