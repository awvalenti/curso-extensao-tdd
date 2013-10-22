package tdd.loja;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class PedidoAVistaTest {

	private Pedido pedido;

	@Before
	public void setUp() {
		pedido = new Pedido();
	}

	@Test
	public void deveCalcularTotalSemProdutos() {
		assertThat(pedido.calcularTotal(), is(new BigDecimal("0.00")));
	}

	@Test
	public void deveCalcularTotalComUmItemUnitario() {
		pedido.adicionar(new ItemPedido(1, new Produto("Geladeira", new BigDecimal("500.00"))));
		assertThat(pedido.calcularTotal(), is(new BigDecimal("500.00")));
	}

	@Test
	public void deveCalcularTotalComDoisItensUnitarios() {
		pedido.adicionar(new ItemPedido(1, new Produto("Geladeira", new BigDecimal("400.00"))));
		pedido.adicionar(new ItemPedido(1, new Produto("Colher de arroz", new BigDecimal("10.00"))));
		assertThat(pedido.calcularTotal(), is(new BigDecimal("410.00")));
	}

	@Test
	public void deveCalcularTotalComItensMultiplos() {
		pedido.adicionar(new ItemPedido(12, new Produto("Prato", new BigDecimal("5.00"))));
		pedido.adicionar(new ItemPedido(2, new Produto("Colher de arroz", new BigDecimal("10.00"))));
		assertThat(pedido.calcularTotal(), is(new BigDecimal("80.00")));
	}

	@Test
	public void deveOferecerDescontoEmVendasAVistaAPartirDe500Reais() {
		pedido.adicionar(new ItemPedido(1, new Produto("Fogao", new BigDecimal("600.00"))));
		assertThat(pedido.calcularTotal(), is(new BigDecimal("540.00")));
	}

}
