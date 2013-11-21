package tdd.truco;

public interface SaidaJogo {

	void aoFazerJogada(Jogador jogador, Carta carta);

	void aoTerminarCiclo(Jogador vencedor);

}
