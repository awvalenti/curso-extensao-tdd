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

}
