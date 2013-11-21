package tdd.truco;

public class SaidaJogoNoConsole implements SaidaJogo {

	@Override
	public void aoFazerJogada(Jogador jogador, Carta carta) {
		System.out.println(jogador + " jogou " + carta);
	}

	@Override
	public void aoTerminarCiclo(Jogador vencedor) {
		System.out.println("Fim de ciclo. " + vencedor + " venceu.");
	}

}
