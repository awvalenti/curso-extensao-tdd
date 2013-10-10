package valenti.aula1.truco.modelo;

import valenti.aula1.truco.modelo.resultadorodada.Empate;
import valenti.aula1.truco.modelo.resultadorodada.ResultadoRodada;

public class Mesa extends ColecaoCartas {

	private final int numeroJogadores;

	public Mesa(int numeroJogadores) {
		this.numeroJogadores = numeroJogadores;
	}

	public boolean estahCompleta() {
		return getQuantidade() >= numeroJogadores;
	}

	public ResultadoRodada calcularResultadoRodadaPequena() {
		// Talvez precise associar cada carta a um jogador na hora de lancar na mesa
		return new Empate();
	}

}
