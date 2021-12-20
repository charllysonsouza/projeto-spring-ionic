package com.cursomc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursomc.models.Cidade;
import com.cursomc.services.CidadeService;

@RestController
@RequestMapping(path = "cidades")
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@PostMapping
	public Cidade create(@RequestBody Cidade c){
		return this.cidadeService.create(c);
	}

}
