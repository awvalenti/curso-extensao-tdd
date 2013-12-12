package tdd.truco.nucleo.resultado;

import tdd.truco.nucleo.Jogador;

public class FabricaResultado {

	public static Resultado vencedor(Jogador jogador) {
		return new ResultadoComVencedor(jogador);
	}

	public static Resultado emAndamento() {
		return ResultadoEstatico.EM_ANDAMENTO;
	}

	public static Resultado empate() {
		return ResultadoEstatico.EMPATE;
	}

}
