package Caixa_Eletronico;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Caixa {
	private ArrayList<Dinheiro> cedulas;
	
	public ArrayList<Dinheiro> getCedulas() {
		return cedulas;
	}

	public void setCedulas(ArrayList<Dinheiro> cedulas) {
		this.cedulas = cedulas;
	}

	public ArrayList<Dinheiro> saque(int valor) {
		int valorCedulas = 50;
		double qtdCedulas = 0;
		cedulas = new ArrayList<Dinheiro>();
		if (valor % valorCedulas == 0) {
			qtdCedulas = (valor / valorCedulas);
			for(int i = 0; i < qtdCedulas; i++) {		
				Dinheiro cedula = new Dinheiro();
				cedula.setValor(valorCedulas);
				cedulas.add(cedula);
			}
		}
		else {
			System.out.println("Notas de 50 não disponíveis para a quantidade informada, informe um valor válido");
		}

		return cedulas;
	}
	
	public static void main(String[] args)  {
		int cont = 0;
		int valor = 0;
		String senha;
		Caixa caixa = new Caixa();
		Scanner in = new Scanner(System.in);
		System.out.println("Informe a senha do cartão");
		senha = in.nextLine();
		Cartao cartao = new Cartao();
		cartao.setSenha(senha);
		System.out.println("Informe o valor a ser sacado");
		valor = in.nextInt();	
		caixa.saque(valor);
		if(caixa.cedulas != null) {
			for(Iterator<Dinheiro> i = caixa.cedulas.iterator(); i.hasNext(); ) {
				  Dinheiro cedula = i.next();
				  cont++;
				  System.out.println("Quatidade de notas de 50 reais sacadas: " + cont);
			}	
		}
	}
}
