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
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + 
				", Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll(){
		List<Categoria> obj = categoriaRepository.findAll();
		return obj;
	}
	
	public Categoria insert(Categoria cat) {
		// o id precisa necessariamente estar valendo null, caso contrário o método save considera um update
		cat.setId(null);  
		return categoriaRepository.save(cat);
	}
	
	public Categoria update(Categoria cat) {
		findById(cat.getId());
		return categoriaRepository.save(cat);
	}

}
