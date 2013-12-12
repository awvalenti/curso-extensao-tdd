package tdd.truco;

public interface SaidaJogo {

	void rodadaIniciada();

	void cicloIniciado(Jogador primeiroAJogar);

	void jogadaFeita(Jogador jogador, Carta carta);

	void cicloFechadoComVencedor(Jogador vencedor);

}
