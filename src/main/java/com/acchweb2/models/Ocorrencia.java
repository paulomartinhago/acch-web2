package com.acchweb2.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ocorrencia implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codOcorrencia;
	
	private Date data;
	
	@ManyToOne
	private Servidor servidor;
	
	@ManyToOne
	private Veiculo veiculo;

	public long getCodOcorrencia() {
		return codOcorrencia;
	}

	public void setCodOcorrencia(long codOcorrencia) {
		this.codOcorrencia = codOcorrencia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
}