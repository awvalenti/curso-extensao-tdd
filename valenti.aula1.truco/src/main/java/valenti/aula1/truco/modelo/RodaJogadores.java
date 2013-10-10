package valenti.aula1.truco.modelo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RodaJogadores implements Iterable<Jogador> {

	private List<Jogador> jogadores;
	private int indiceJogadorAtual;

	public RodaJogadores(Jogador... jogadores) {
		this.jogadores = Arrays.asList(jogadores);
		this.indiceJogadorAtual = 0;
	}

	public void moverParaProximo() {
		indiceJogadorAtual = (indiceJogadorAtual + 1) % jogadores.size();
	}

	public Jogador getJogadorAtual() {
		return jogadores.get(indiceJogadorAtual);
	}

	@Override
	public Iterator<Jogador> iterator() {
		return jogadores.iterator();
	}

}
