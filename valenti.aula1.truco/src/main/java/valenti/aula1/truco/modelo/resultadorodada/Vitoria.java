package valenti.aula1.truco.modelo.resultadorodada;

import valenti.aula1.truco.modelo.Jogador;

public class Vitoria extends ResultadoRodada {

	private final Jogador jogador;

	public Vitoria(Jogador jogador) {
		this.jogador = jogador;
	}

	@Override
	public String toString() {
		return "Vitoria de " + jogador;
	}

}
