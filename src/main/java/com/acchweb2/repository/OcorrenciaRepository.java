package com.acchweb2.repository;

import org.springframework.data.repository.CrudRepository;

import com.acchweb2.models.Ocorrencia;

public interface OcorrenciaRepository extends CrudRepository<Ocorrencia, String> {
	
}
