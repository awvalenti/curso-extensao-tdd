package tdd.loja;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class PedidoAPrazoTest {

	private Pedido pedido;

	@Before
	public void setUp() {
		pedido = new Pedido();
		pedido.setNumeroParcelas(2);
	}

	@Test
	public void deveAcrescerJurosDe5PorCentoENaoConcederDesconto() {
		pedido.adicionar(new ItemPedido(2, new Produto("Liquidificador", new BigDecimal("50.00"))));
		assertThat(pedido.calcularTotal(), is(new BigDecimal("105.00")));
	}

}
