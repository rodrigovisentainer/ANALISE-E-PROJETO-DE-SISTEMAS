package org.catolicasc.veterinaria.modelo;

import java.util.Calendar;

public class Fatura {

	private Cliente cliente;
	private double valor;
	private boolean isPago;
	private Calendar dataVencimento;

	public Fatura(Cliente cliente, double valor, boolean pago, Calendar dataVencimento) {
		this.cliente = cliente;
		this.valor = valor;
		this.isPago = pago;
		this.dataVencimento = dataVencimento;
	}

	public Calendar getDataVencimento() {
		return this.dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
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

	public boolean isPago() {
		return this.isPago;
	}

	public void setPago(boolean isPago) {
		this.isPago = isPago;
	}

	public Recibo pagar() {
		Recibo recibo = new Recibo(this.cliente, this.valor, Calendar.getInstance());
		this.isPago = true;
		return recibo;
	}

	public Recibo pagar(Calendar dataDePagamento) {
		Recibo recibo = new Recibo(this.cliente, this.valor, dataDePagamento);
		this.isPago = true;
		return recibo;
	}

}
