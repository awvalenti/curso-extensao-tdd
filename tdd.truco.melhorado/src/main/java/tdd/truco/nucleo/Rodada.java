package tdd.truco.nucleo;

import static tdd.truco.nucleo.resultado.FabricaResultado.*;
import tdd.truco.nucleo.resultado.Resultado;

public class Rodada {

	private final EstadoCiclos estadoCiclos;

	public Rodada(EstadoCiclos estadoCiclos) {
		this.estadoCiclos = estadoCiclos;
	}

	public Resultado calcularResultado() {
		if (estadoCiclos.getQuantidadeCiclos() >= 2) {
			Resultado resultadoCiclo0 = estadoCiclos.calcularResultadoDoCiclo(0);
			Resultado resultadoCiclo1 = estadoCiclos.calcularResultadoDoCiclo(1);

			if (resultadoCiclo0.temVencedor() && resultadoCiclo0.equals(resultadoCiclo1)) return resultadoCiclo0;

			if (estadoCiclos.getQuantidadeCiclos() == 3) return estadoCiclos.calcularResultadoDoCiclo(2);
		}

		return emAndamento();
	}

}
