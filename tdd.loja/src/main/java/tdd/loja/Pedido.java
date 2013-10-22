package tdd.loja;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private List<ItemPedido> itens = new ArrayList<>();
	private int numeroParcelas;

	public void adicionar(ItemPedido itemPedido) {
		itens.add(itemPedido);
	}

	public void setNumeroParcelas(int numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

	public BigDecimal calcularTotal() {
		BigDecimal total = BigDecimal.ZERO;

		for (ItemPedido item : itens) {
			total = total.add(item.calcularPreco());
		}

		if (numeroParcelas > 1) {
			total = total.multiply(new BigDecimal("1.05"));

		} else if (total.compareTo(BigDecimal.valueOf(500)) > 0) {
			total = total.multiply(new BigDecimal("0.9"));
		}

		return total.setScale(2, RoundingMode.DOWN);
	}

}
