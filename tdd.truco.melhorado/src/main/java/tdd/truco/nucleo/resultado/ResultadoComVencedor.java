package tdd.truco.nucleo.resultado;

import tdd.truco.nucleo.Jogador;

class ResultadoComVencedor implements Resultado {
	private Jogador jogador;

	public ResultadoComVencedor(Jogador jogador) {
		this.jogador = jogador;
	}

	@Override
	public boolean equals(Object outro) {
		return outro instanceof ResultadoComVencedor && jogador.equals(((ResultadoComVencedor) outro).jogador);
	}

	@Override
	public boolean temVencedor() {
		return true;
	}

	@Override
	public String toString() {
		return "vencedor(" + jogador + ")";
	}

}
