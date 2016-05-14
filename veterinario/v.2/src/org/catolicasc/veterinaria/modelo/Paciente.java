package org.catolicasc.veterinaria.modelo;

public class Paciente {

	private Long id;
	private String nome;
	private String raca;
	private Cliente cliente;

	public Paciente(String nome, String raca, Cliente cliente) {
		this.nome = nome;
		this.raca = raca;
		this.cliente = cliente;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaca() {
		return this.raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Cliente getProprietario() {
		return this.cliente;
	}

	public void setProprietario(Cliente cliente) {
		this.cliente = cliente;
	}
}
