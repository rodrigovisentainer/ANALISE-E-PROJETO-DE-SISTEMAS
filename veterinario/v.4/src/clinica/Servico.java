package org.catolicasc.veterinaria.modelo;

public class Servico {
	private String descricao;
	private Paciente paciente;
	private double valor;

	public Servico(String descricao, Paciente paciente, double valor) {
		this.descricao = descricao;
		this.paciente = paciente;
		this.valor = valor;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
