package tdd.truco;

import java.util.List;

public class Ciclo {

	private final SaidaJogo saida;
	private final List<Jogada> jogadas;

	public Ciclo(SaidaJogo saida, List<Jogada> jogadas) {
		this.saida = saida;
		this.jogadas = jogadas;
	}

	public void fazerJogada(Jogador jogador, Carta carta) {
		if (!permiteJogadaDe(jogador)) throw new IllegalStateException(jogador + " tentou jogar duas vezes seguidas");

		jogadas.add(new Jogada(jogador, carta));
		saida.aoFazerJogada(jogador, carta);

		if (terminou()) saida.aoTerminarCiclo(calcularVencedor());
	}

	public boolean terminou() {
		return jogadas.size() == 2;
	}

	public Jogador calcularVencedor() {
		if (!terminou()) throw new IllegalStateException("So' pode calcular vencedor quando o ciclo terminar");

		return jogadas.get(1).getJogador();
	}

	private boolean permiteJogadaDe(Jogador jogador) {
		return jogadas.isEmpty() || !jogadas.get(jogadas.size() - 1).getJogador().equals(jogador);
	}

}
