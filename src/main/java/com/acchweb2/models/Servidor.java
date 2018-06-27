package com.acchweb2.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Servidor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codServidor;
	
	private String nome;
	private String telefone;
	private int ramal;
	private String sala;
	private String cargo;
	
	@OneToMany
	private List<Ocorrencia> ocorrencias;
	
	public long getCodServidor() {
		return codServidor;
	}
	
	public void setCodServidor(long codServidor) {
		this.codServidor = codServidor;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public int getRamal() {
		return ramal;
	}
	
	public void setRamal(int ramal) {
		this.ramal = ramal;
	}
	
	public String getSala() {
		return sala;
	}
	
	public void setSala(String sala) {
		this.sala = sala;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
}