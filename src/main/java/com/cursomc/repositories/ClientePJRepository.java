package com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursomc.models.ClientePJ;

@Repository
public interface ClientePJRepository extends JpaRepository<ClientePJ, Integer> {

}