package Jogo_Dados;
public class Game {
	private Dice a;
	private Dice b;
	
	public Dice getA() {
		return a;
	}
	public void setA(Dice a) {
		this.a = a;
	}
	public Dice getB() {
		return b;
	}
	public void setB(Dice b) {
		this.b = b;
	}
	
	public boolean play() {
		int dado1 = a.roll(a);
		int dado2 = b.roll(b);
		int result = dado1 + dado2;
		if(result == 7) {
			System.out.println("Você Ganhou!" + " resultado: " + result);
			return true;
		}
		else {
			System.out.println("Você Perdeu!" + " resultado: " + result);
			return false;
		}
	}
	public static void main(String[] args) {
		Game game = new Game();
		game.a = new Dice();
		game.b = new Dice();
		game.play();
	}
}
