package br.comvarejonline.projetoinicial.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;

@RestController
public class HomeController {
	
	@GetMapping(path = "/ping")
	public String ping(HttpServletRequest request) {

		return ZonedDateTime.now().toString();
	}
	
	
}
