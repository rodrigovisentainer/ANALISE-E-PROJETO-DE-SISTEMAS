package org.catolicasc.veterinaria.testes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.catolicasc.veterinaria.modelo.Cliente;
import org.catolicasc.veterinaria.modelo.Fatura;
import org.catolicasc.veterinaria.modelo.OrdemServico;
import org.catolicasc.veterinaria.modelo.Paciente;
import org.catolicasc.veterinaria.modelo.Recibo;
import org.catolicasc.veterinaria.modelo.Servico;
import org.junit.Test;

public class VeterinariaTest {

	@Test
	public void CasoDeUsoUmTest() {
		Cliente dave = new Cliente("Dave Atkins", "9999999");
		Paciente fofo = new Paciente("Fofo", "Doberman", dave);

		Servico exameRotina = new Servico("Exame de rotina", fofo, 220);
		Servico vacina = new Servico("Vacina contra raiva", fofo, 100);
		Servico consulta = new Servico("Consulta de rotina", fofo, 60);

		List<Servico> servicos = new ArrayList<>();
		servicos.add(exameRotina);
		servicos.add(vacina);
		servicos.add(consulta);

		OrdemServico ordemServico = new OrdemServico(servicos, dave, Calendar.getInstance());

		Fatura fatura = ordemServico.geraFatura(Calendar.getInstance());

		fatura.pagar();
	}

	@Test
	public void CasoDeUsoDoisTest() {
		Cliente traci = new Cliente("Traci", "9999999");
		Paciente tweedleDee = new Paciente("Tweedle Dee", "Gato", traci);
		Paciente tweedleDum = new Paciente("Tweedle Dum", "Gato", traci);

		Servico est_dee = new Servico("Esterilizacao", tweedleDee, 50);
		Servico est_dum = new Servico("Esterilizacao", tweedleDum, 50);

		List<Servico> servicos = new ArrayList<>();
		servicos.add(est_dee);
		servicos.add(est_dum);

		Calendar dataOS = Calendar.getInstance();

		OrdemServico ordemServico = new OrdemServico(servicos, traci, dataOS);

		Calendar dataVencimento = Calendar.getInstance();

		Fatura fatura = ordemServico.geraFatura(dataVencimento);

		Calendar dataDePagamento = Calendar.getInstance();

		Recibo recibo = fatura.pagar(dataDePagamento);

		System.out.println("Nome: " + recibo.getCliente().getNome() + " ::: Valor: " + recibo.getValor()
				+ " ::: Data pagamento: " + recibo.getDataPagamento().getTime());
	}

}
