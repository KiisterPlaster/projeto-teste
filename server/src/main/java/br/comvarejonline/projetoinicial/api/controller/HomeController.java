package br.comvarejonline.projetoinicial.api.controller;

import java.time.ZonedDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.comvarejonline.projetoinicial.domain.model.Usuario;
import br.comvarejonline.projetoinicial.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path = "/ping")
	public String ping(HttpServletRequest request) {

		return ZonedDateTime.now().toString();
	}
	
	
	@PostMapping
	public Usuario create(@RequestBody Usuario usuario) {
		return userRepository.save(usuario);
	}
	
	@GetMapping
	public List<Usuario> list() {
		return userRepository.findAll();
	}
	
}
