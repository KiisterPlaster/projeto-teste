package br.comvarejonline.projetoinicial.api.controller;

import br.comvarejonline.projetoinicial.api.assembler.ProdutoInputDisassembler;
import br.comvarejonline.projetoinicial.api.assembler.ProdutoModelAssembler;
import br.comvarejonline.projetoinicial.api.model.input.ProdutoInput;
import br.comvarejonline.projetoinicial.api.model.view.ProdutoDTO;
import br.comvarejonline.projetoinicial.domain.model.Produto;
import br.comvarejonline.projetoinicial.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoInputDisassembler produtoInputDisassembler;
	
	@Autowired
	private ProdutoModelAssembler produtoModelAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProdutoDTO create(@RequestBody ProdutoInput produtoInput) {
		try{
			Produto novoProduto = produtoInputDisassembler.toDomainObject(produtoInput);
			
			return produtoModelAssembler.toModel(produtoRepository.save(novoProduto));
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@GetMapping
	public List<Produto> list() {
		return produtoRepository.findAll();
	}
	
}
