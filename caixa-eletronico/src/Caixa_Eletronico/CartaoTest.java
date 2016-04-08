package Caixa_Eletronico;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class CartaoTest extends TestCase {

	@Test
	public void testCartao() {
		Cartao cartao = new Cartao();
		cartao.setSenha("1155");
		assertEquals("1155", cartao.getSenha());
	}

}
