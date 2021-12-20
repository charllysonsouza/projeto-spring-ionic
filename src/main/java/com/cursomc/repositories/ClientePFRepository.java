package com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursomc.models.ClientePF;

@Repository
public interface ClientePFRepository extends JpaRepository<ClientePF, Integer> {

}
