package tdd.truco.nucleo;

import java.util.ArrayList;
import java.util.List;

import tdd.truco.nucleo.resultado.Resultado;
import static tdd.truco.nucleo.resultado.FabricaResultado.*;

public class EstadoCiclos {

	private List<Ciclo> ciclos = new ArrayList<>();
	private int quantidadeJogadores;

	public EstadoCiclos(int quantidadeJogadores) {
		this.quantidadeJogadores = quantidadeJogadores;
	}

	public int getQuantidadeCiclos() {
		return ciclos.size();
	}

	public Resultado calcularResultadoDoCiclo(int indiceCiclo) {
		return ciclos.get(indiceCiclo).calcularResultado();
	}

	public void incluirJogada(Jogada jogada) {
		if (ciclos.isEmpty() || !ultimoCiclo().calcularResultado().equals(emAndamento())) {
			ciclos.add(new Ciclo(new EstadoJogadas(), quantidadeJogadores));
		}

		ultimoCiclo().acrescentarJogada(jogada);
	}

	private Ciclo ultimoCiclo() {
		return ciclos.get(ciclos.size() - 1);
	}

}
