package com.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomc.models.Cidade;
import com.cursomc.repositories.CidadeRepository;
import com.cursomc.repositories.EstadoRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Cidade create(Cidade c) {
		
		if(c.getEstado() != null) {
			estadoRepository.save(c.getEstado());
		}
		return this.cidadeRepository.save(c);
	}
	

}
