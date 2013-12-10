package tdd.truco;

import java.util.List;

public class Rodada {

	private final List<Ciclo> ciclos;

	public Rodada(List<Ciclo> ciclos) {
		this.ciclos = ciclos;
	}

	public boolean terminou() {
		return ciclos.size() == 3 || ciclos.size() == 2 && ciclos.get(0).calcularVencedor().equals(ciclos.get(1).calcularVencedor());
	}

	public Jogador calcularVencedor() {
		Jogador vencedor0 = ciclos.get(0).calcularVencedor();
		Jogador vencedor1 = ciclos.get(1).calcularVencedor();

		if (ciclos.size() == 2 && vencedor0.equals(vencedor1)) return vencedor0;

		Jogador vencedor2 = ciclos.get(2).calcularVencedor();

		return vencedor0.equals(vencedor2) ? vencedor0 : vencedor1;
	}

}
