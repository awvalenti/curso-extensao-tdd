package tdd.truco.nucleo;

import java.util.Collections;
import java.util.List;

import tdd.truco.nucleo.resultado.Resultado;
import static tdd.truco.nucleo.resultado.FabricaResultado.*;

public class Ciclo {

	private EstadoJogadas estadoJogadas;
	private int quantidadeJogadores;

	public Ciclo(EstadoJogadas estadoJogadas, int quantidadeJogadores) {
		this.estadoJogadas = estadoJogadas;
		this.quantidadeJogadores = quantidadeJogadores;
	}

	public Resultado calcularResultado() {
		List<Jogada> jogadas = estadoJogadas.getJogadas();

		if (jogadas.size() < quantidadeJogadores) {
			return emAndamento();

		} else {
			Collections.sort(jogadas);

			Jogada jogadaMaisAlta = jogadas.get(jogadas.size() - 1);
			Jogada segundaJogadaMaisAlta = jogadas.get(jogadas.size() - 2);

			return jogadaMaisAlta.compareTo(segundaJogadaMaisAlta) == 0 ? empate() : vencedor(jogadaMaisAlta.getJogador());
		}
	}

	public void acrescentarJogada(Jogada jogada) {
		estadoJogadas.acrescentarJogada(jogada);
	}

	public int getQuantidadeJogadas() {
		return estadoJogadas.getJogadas().size();
	}

}
