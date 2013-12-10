package tdd.truco;

public class SaidaJogoNoConsole implements SaidaJogo {

	@Override
	public void jogadaFeita(Jogador jogador, Carta carta) {
		System.out.println(jogador + " jogou " + carta);
	}

	@Override
	public void cicloFechadoComVencedor(Jogador vencedor) {
		System.out.println("Fim de ciclo. " + vencedor + " venceu.");
	}

	@Override
	public void rodadaIniciada() {
		System.out.println("Inicio da rodada");
	}

	@Override
	public void cicloIniciado(Jogador primeiroAJogar) {
		System.out.println("Inicio do ciclo. Vez de " + primeiroAJogar);
	}

}
