package org.catolicasc.veterinaria.modelo;

import java.util.Calendar;

public class Recibo {

	private Cliente cliente;
	private double valor;
	private Calendar dataPagamento;

	public Recibo(Cliente cliente, double valor, Calendar dataPagamento) {
		this.cliente = cliente;
		this.valor = valor;
		this.dataPagamento = dataPagamento;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDataPagamento() {
		return this.dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
