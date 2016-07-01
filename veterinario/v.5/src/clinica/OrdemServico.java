package org.catolicasc.veterinaria.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author jhony.senem
 */

public class OrdemServico {

	private List<Servico> servicos;
	private Cliente cliente;
	private Calendar date;

	/**
	 * @param servicos
	 * @param cliente
	 * @param data
	 */
	public OrdemServico(List<Servico> servicos, Cliente cliente, Calendar data) {
		this.servicos = servicos;
		this.cliente = cliente;
		this.date = data;
	}

	public List<Servico> getServicos() {
		return this.servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Cliente getProprietario() {
		return this.cliente;
	}

	public void setProprietario(Cliente cliente) {
		this.cliente = cliente;
	}

	public Calendar getDate() {
		return this.date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 * Criação da fatura.
	 *
	 * @param dataVencimento:
	 *            Data de vencimento da fatura.
	 * @return fatura
	 */
	public Fatura geraFatura(Calendar dataVencimento) {
		Fatura fatura;
		double valor = 0.0;

		for (Servico servico : this.servicos) {
			valor += servico.getValor();
		}

		fatura = new Fatura(this.cliente, valor, false, dataVencimento);

		return fatura;
	}

	public List<Fatura> geraFaturas(Calendar dataVencimento, List<Cota> cotas) {
		double valor = 0.0;
		double valorCota = 0.0;
		Fatura fatura;
		List<Fatura> faturas = new ArrayList<>();

		for (Servico servico : this.servicos) {
			valor += servico.getValor();
		}

		for (Cota cota : cotas) {
			valorCota = valor * (0.01 * cota.getPorcentagem());
			fatura = new Fatura(cota.getCliente(), valorCota, false, dataVencimento);
			faturas.add(fatura);
		}

		return faturas;
	}

}
