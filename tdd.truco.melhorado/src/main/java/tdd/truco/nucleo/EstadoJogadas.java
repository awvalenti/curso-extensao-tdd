package tdd.truco.nucleo;

import java.util.ArrayList;
import java.util.List;

public class EstadoJogadas {

	private List<Jogada> jogadas = new ArrayList<>();

	public List<Jogada> getJogadas() {
		return jogadas;
	}

	public void acrescentarJogada(Jogada jogada) {
		jogadas.add(jogada);
	}

}
