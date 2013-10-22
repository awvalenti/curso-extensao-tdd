package tdd.loja;

import java.math.BigDecimal;

public class Produto {

	private BigDecimal preco;
	private String nome;

	public Produto(String nome, BigDecimal preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	@Override
	public String toString() {
		return nome + ": " + preco;
	}

}
