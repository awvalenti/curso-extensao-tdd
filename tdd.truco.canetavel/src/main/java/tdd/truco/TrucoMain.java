package tdd.truco;

import java.util.ArrayList;

public class TrucoMain {

	public static void main(String[] args) {
		Jogador jogador1 = new Jogador("Jogador 1");
		Jogador jogador2 = new Jogador("Jogador 2");

		Ciclo ciclo = new Ciclo(new SaidaJogoNoConsole(), new ArrayList<Jogada>());

		ciclo.fazerJogada(jogador1, Carta.QUATRO);
		ciclo.fazerJogada(jogador2, Carta.AS);
	}
}
