package com.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomc.models.Categoria;
import com.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRespository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRespository.findById(id);
		return obj.orElse(null);
	}
	
	public List<Categoria> findAll(){
		List<Categoria> obj = categoriaRespository.findAll();
		return obj;
	}

}
