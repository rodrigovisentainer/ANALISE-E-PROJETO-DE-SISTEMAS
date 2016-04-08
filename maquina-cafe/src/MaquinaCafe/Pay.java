package analise.aula03;

public class Pay  {
	private double money;
	

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	public double payCoffee(double money){
		if(money == 0.35){
			System.out.println("Por favor escolha o café desejado");
		}else{
			if(money > 0.35){
				double troco = money - 0.35;
				System.out.println("Por favor escolha o café desejado e receba seu troco :"+ troco);
				return troco;
			}else{
				System.out.println("Dinheiro insuficiente");
				return money;
			}
		}
			return money;
	}

}
