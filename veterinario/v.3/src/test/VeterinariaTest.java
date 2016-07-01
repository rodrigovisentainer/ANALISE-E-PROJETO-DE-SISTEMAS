package org.catolicasc.veterinaria.testes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.catolicasc.veterinaria.modelo.Cliente;
import org.catolicasc.veterinaria.modelo.Cota;
import org.catolicasc.veterinaria.modelo.Fatura;
import org.catolicasc.veterinaria.modelo.OrdemServico;
import org.catolicasc.veterinaria.modelo.Paciente;
import org.catolicasc.veterinaria.modelo.Recibo;
import org.catolicasc.veterinaria.modelo.Servico;
import org.junit.Test;

public class VeterinariaTest {

	@Test
	public void CasoDeUsoUmTest() {
		ArrayList<Cliente> clientes = new ArrayList<>();
		Cliente dave = new Cliente("Dave Atkins", "9999999");
		clientes.add(dave);

		Paciente fofo = new Paciente("Fofo", "Doberman", clientes);

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
		ArrayList<Cliente> clientes = new ArrayList<>();
		Cliente traci = new Cliente("Traci", "9999999");
		clientes.add(traci);

		Paciente tweedleDee = new Paciente("Tweedle Dee", "Gato", clientes);
		Paciente tweedleDum = new Paciente("Tweedle Dum", "Gato", clientes);

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

		fatura.pagar(dataDePagamento);
	}

	@Test
	public void CasoDeUsoTresTest() {

		ArrayList<Cliente> clientes = new ArrayList<>();
		ArrayList<Servico> servicos = new ArrayList<>();
		ArrayList<Cota> cotas = new ArrayList<>();

		Cliente grady = new Cliente("Gray Booch", "09090909");
		clientes.add(grady);
		Cliente martin = new Cliente("Martin Flower", "1545454");
		clientes.add(martin);
		Cliente ralph = new Cliente("Ralph Joh", "78787888");
		clientes.add(ralph);
		Cliente erich = new Cliente("Erich Gama", "45555666");
		clientes.add(erich);
		Cliente brian = new Cliente("Brian Foote", "744444555");
		clientes.add(brian);

		Paciente cavalo = new Paciente("Mensagem Polimorfica", "Cavalo", clientes);
		Servico claudificacao = new Servico("Exame de claudificacao", cavalo, 200.0);
		servicos.add(claudificacao);

		Cota cotaGrady = new Cota(grady, cavalo, 30);
		cotas.add(cotaGrady);
		Cota cotaMartin = new Cota(martin, cavalo, 20);
		cotas.add(cotaMartin);
		Cota cotaRalph = new Cota(ralph, cavalo, 20);
		cotas.add(cotaRalph);
		Cota cotaErich = new Cota(erich, cavalo, 10);
		cotas.add(cotaErich);
		Cota cotaBrian = new Cota(brian, cavalo, 20);
		cotas.add(cotaBrian);

		OrdemServico os = new OrdemServico(servicos, ralph, Calendar.getInstance());

		Calendar dataVencimento = Calendar.getInstance();
		List<Fatura> faturas = os.geraFaturas(dataVencimento, cotas);

		Calendar dataPagamento = Calendar.getInstance();

		for (Fatura fat : faturas) {
			fat.pagar(dataPagamento);
		}
	}

	@Test
	public void CasoDeUsoQuatroTest() {
		Cliente ralph = new Cliente("Ralph", "111111111");
		ArrayList<Cliente> clientes = new ArrayList<>();
		clientes.add(ralph);
		Paciente msgPolimorfica = new Paciente("Mensagem Polimorfica", "Cavalo", clientes);

		double taxa = 50.0;
		Servico laceracao = new Servico("Saturar lacerações", msgPolimorfica, taxa + 300);
		List<Servico> servicos = new ArrayList<>();
		servicos.add(laceracao);

		OrdemServico ordemServico = new OrdemServico(servicos, ralph, Calendar.getInstance());
		Calendar dtVencimento = Calendar.getInstance();
		Fatura fatura = ordemServico.geraFatura(dtVencimento);

		Recibo recibo = fatura.pagar();

		System.out.println("Nome: " + recibo.getCliente().getNome() + "\n" + "Valor: " + recibo.getValor()
				+ "\nTaxa de emergencia: " + taxa);

	}

	@Test
	public void OcavaloEAIguana() {
		Cliente ralph = new Cliente("Ralph", "111111111");
		ArrayList<Cliente> clientes = new ArrayList<>();
		clientes.add(ralph);
		Paciente msgPolimorfica = new Paciente("Mensagem Polimorfica", "Cavalo", clientes);
		Paciente coletora = new Paciente("Coletora", "Iguana", clientes);

		Servico exameRotina = new Servico("Exame Rotina", msgPolimorfica, 200);
		Servico exame = new Servico("Exame estomago", coletora, 200);
		List<Servico> servicos = new ArrayList<>();
		servicos.add(exameRotina);
		servicos.add(exame);

		OrdemServico ordemServico = new OrdemServico(servicos, ralph, Calendar.getInstance());
		Calendar dtVencimento = Calendar.getInstance();
		ArrayList<Cota> cotas = new ArrayList<>();

		Cliente grady = new Cliente("Gray Booch", "09090909");
		clientes.add(grady);
		Cliente martin = new Cliente("Martin Flower", "1545454");
		clientes.add(martin);
		clientes.add(ralph);
		Cliente erich = new Cliente("Erich Gama", "45555666");
		clientes.add(erich);
		Cliente brian = new Cliente("Brian Foote", "744444555");
		clientes.add(brian);

		List<Fatura> faturas = ordemServico.geraFaturas(dtVencimento, cotas);

		for (Fatura fat : faturas) {
			Recibo recibo = fat.pagar();
			System.out.println("Nome: " + recibo.getCliente().getNome() + "\n Valor: " + recibo.getValor());
		}
	}
}
