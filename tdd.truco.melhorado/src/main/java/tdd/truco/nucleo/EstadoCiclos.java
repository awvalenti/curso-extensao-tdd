package tdd.truco.nucleo;

import tdd.truco.nucleo.resultado.Resultado;

public interface EstadoCiclos {

	int getQuantidadeCiclos();

	Resultado calcularResultadoDoCiclo(int indiceCiclo);

}
