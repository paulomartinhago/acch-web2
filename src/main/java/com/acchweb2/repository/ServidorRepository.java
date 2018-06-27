package com.acchweb2.repository;

import org.springframework.data.repository.CrudRepository;

import com.acchweb2.models.Servidor;

public interface ServidorRepository extends CrudRepository<Servidor, String> {
	Servidor findByCodServidor(long codServidor);
}
