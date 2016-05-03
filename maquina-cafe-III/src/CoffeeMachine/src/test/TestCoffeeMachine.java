package test;

import static org.junit.Assert.*;
import org.junit.Test;
import coffee.AllCooffees;
import coffee.Pay;

public class TestCoffeeMachine {

	@Test
	public void TestAllCoffees() {

		String expected = "Caf� preto";
		String expected1 = "Caf� com a�ucar";
		String expected2 = "Caf� com creme";
		String expected3 = "Caf� com creme e a�ucar";

		AllCooffees cafes = new AllCooffees();
		cafes.coffeeBlack(expected);
		cafes.coffeeWithSugar(expected1);
		cafes.coffeeWithCream(expected2);
		cafes.coffeeWithCreamAndSugar(expected3);

		assertEquals(expected, "Caf� preto");
		assertEquals(expected1, "Caf� com a�ucar");
		assertEquals(expected2, "Caf� com creme");
		assertEquals(expected3, "Caf� com creme e a�ucar");

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
