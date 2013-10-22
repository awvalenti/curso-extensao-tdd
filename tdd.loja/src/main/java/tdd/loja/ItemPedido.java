package tdd.loja;

import java.math.BigDecimal;

public class ItemPedido {

	private Produto produto;
	private int quantidade;

	public ItemPedido(int quantidade, Produto produto) {
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public BigDecimal calcularPreco() {
		return produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
	}

}
