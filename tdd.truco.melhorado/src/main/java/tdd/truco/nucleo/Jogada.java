package tdd.truco.nucleo;

public class Jogada implements Comparable<Jogada> {

	private Jogador jogador;
	private Carta carta;

	public Jogada(Jogador jogador, Carta carta) {
		this.jogador = jogador;
		this.carta = carta;
	}

	@Override
	public int compareTo(Jogada outra) {
		return carta.compareTo(outra.carta);
	}

	public Jogador getJogador() {
		return jogador;
	}

}
