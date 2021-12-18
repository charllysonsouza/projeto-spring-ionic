package com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursomc.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
