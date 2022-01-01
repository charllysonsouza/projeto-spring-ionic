package com.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomc.models.Categoria;
import com.cursomc.repositories.CategoriaRepository;
import com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRespository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRespository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + 
				", Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll(){
		List<Categoria> obj = categoriaRespository.findAll();
		return obj;
	}
	
	public Categoria insert(Categoria cat) {
		cat.setId(null);
		return this.categoriaRespository.save(cat);
	}

}
