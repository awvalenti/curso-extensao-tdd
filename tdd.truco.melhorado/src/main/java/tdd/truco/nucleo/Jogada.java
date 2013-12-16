package tdd.truco.nucleo;

public class Jogada implements Comparable<Jogada> {

	private Jogador jogador;
	private Carta carta;

	public Jogada(Jogador jogador, Carta carta) {
		this.jogador = jogador;
		this.carta = carta;
	}

	public Jogador getJogador() {
		return jogador;
	}

	@Override
	public int compareTo(Jogada outra) {
		return carta.compareTo(outra.carta);
	}

	@Override
	public String toString() {
		return jogador + ">" + carta;
	}

}
