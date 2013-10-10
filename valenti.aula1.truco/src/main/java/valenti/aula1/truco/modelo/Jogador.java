package valenti.aula1.truco.modelo;

import valenti.aula1.truco.interfaces.EntradaJogo;

public class Jogador {

	private ColecaoCartas mao;
	private String nome;
	private EntradaJogo entradaJogo;

	public Jogador(String nome, EntradaJogo entradaJogo) {
		this.nome = nome;
		this.entradaJogo = entradaJogo;
		this.mao = new ColecaoCartas();
	}

	public ColecaoCartas getMao() {
		return mao;
	}

	public void comprar(int quantidadeCartas, ColecaoCartas colecaoCartas) {
		mao.comprar(quantidadeCartas, colecaoCartas);
	}

	public void lancarCartaNaMesa(int indiceCarta) {
		entradaJogo.lancarCartaNaMesa(this, indiceCarta);
	}

	@Override
	public String toString() {
		return nome;
	}

	public Carta retirarCarta(int indiceCarta) {
		return mao.retirarCarta(indiceCarta);
	}

}
