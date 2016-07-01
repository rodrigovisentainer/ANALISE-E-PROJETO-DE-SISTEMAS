package org.catolicasc.veterinaria.modelo;

public class Cota {

	private Cliente cliente;
	private Paciente paciente;
	private int porcentagem;

	public Cota(Cliente cli, Paciente pac, int porcen) {
		this.cliente = cli;
		this.paciente = pac;
		this.porcentagem = porcen;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public int getPorcentagem() {
		return this.porcentagem;
	}

	public void setPorcentagem(int porcentagem) {
		this.porcentagem = porcentagem;
	}

}
