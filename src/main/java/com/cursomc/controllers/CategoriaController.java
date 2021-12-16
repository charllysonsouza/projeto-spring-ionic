package com.cursomc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {
	
	@GetMapping
	public String listar() {
		return "REST está funcionando";
	}
}
