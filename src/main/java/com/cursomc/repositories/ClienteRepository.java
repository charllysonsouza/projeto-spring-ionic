package com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursomc.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
