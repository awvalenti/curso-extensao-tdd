package tdd.truco;

public class Jogada {

	private Jogador jogador;
	private Carta carta;

	public Jogada(Jogador jogador, Carta carta) {
		this.jogador = jogador;
		this.carta = carta;
	}

	public Carta getCarta() {
		return carta;
	}

	public Jogador getJogador() {
		return jogador;
	}

}
