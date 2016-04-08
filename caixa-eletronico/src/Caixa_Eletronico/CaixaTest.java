package Caixa_Eletronico;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class CaixaTest extends TestCase {

	@Test
	public void testCaixa() {
		Caixa caixa = new Caixa();
		caixa.saque(1000);
		assertEquals(20, caixa.getCedulas().size());
	}

}
