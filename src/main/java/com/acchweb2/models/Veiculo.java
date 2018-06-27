package com.acchweb2.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Veiculo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codVeiculo;
	
	private String tipo;
	private String modelo;
	private String fabricante;
	private String placa;
	private String cor;
	
	@OneToOne
	private Servidor servidor;
	
	@OneToMany
	private List<Ocorrencia> ocorrencias;
	
	public long getCodVeiculo() {
		return codVeiculo;
	}
	
	public void setCodVeiculo(long codVeiculo) {
		this.codVeiculo = codVeiculo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}
}