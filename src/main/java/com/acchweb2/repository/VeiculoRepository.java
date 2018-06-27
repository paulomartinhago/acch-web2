package com.acchweb2.repository;

import org.springframework.data.repository.CrudRepository;

import com.acchweb2.models.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, String> {
	Veiculo findByCodVeiculo(long codVeiculo);
}
