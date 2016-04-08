package analise.test;

import static org.junit.Assert.*;
import org.junit.Test;
import analise.aula03.AllCoffees;
import analise.aula03.Pay;

public class TestCoffeMachine {

	@Test
	public void TestAllCoffees() {

		String expected = "Café preto";
		String expected1 = "Café com açucar";
		String expected2 = "Café com creme";
		String expected3 = "Café com creme e açucar";

		AllCoffees cafes = new AllCoffees();
		cafes.coffeeBlack(expected);
		cafes.coffeeWithSugar(expected1);
		cafes.coffeeWithCream(expected2);
		cafes.coffeeWithCreamAndSugar(expected3);

		assertEquals(expected, "Café preto");
		assertEquals(expected1, "Café com açucar");
		assertEquals(expected2, "Café com creme");
		assertEquals(expected3, "Café com creme e açucar");

	}

	@Test
	public void valueCoffee() {
		double money = 0;
		Pay pay = new Pay();
		if (pay.payCoffee(money) == 0.35) {
			assertEquals(pay, pay.getMoney());
		}
	}

	@Test
	public void ChangeCoffee() {
		Pay pay = new Pay();
		if (pay.getMoney() > 0.35) {
			double troco = pay.payCoffee(1) - 0.35;
			assertEquals(pay, troco);
		}

	}
	
	@Test
	public void insuficientMoney(){
		Pay pay = new Pay();
		if(pay.getMoney() < 0.35){
			assertEquals(pay, pay);
		}
	}

}
