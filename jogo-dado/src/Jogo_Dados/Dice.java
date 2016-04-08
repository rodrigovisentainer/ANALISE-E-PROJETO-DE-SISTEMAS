package Jogo_Dados;
import java.util.Random;

public class Dice {
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int roll(Dice dice) {
		Random rand = new Random();
		int jogada = rand.nextInt(6) + 1;
		dice.setValue(jogada);
		return dice.getValue();		
	}
}