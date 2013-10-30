package tdd.jenga;

import java.util.Random;

public class Jenga {

	private int contadorJogadas;
	private boolean torreDestruida;
	private Random random;

	public Jenga() {
		levarAoEstadoInicial();
	}
	
	public void fazerMovimentoCerto() {
		fazerMovimento();
	}

	public void fazerMovimentoErrado() {
		fazerMovimento();
		torreDestruida = true;
	}

	public int getNumeroAndaresCompletos() {
		return 18 + contadorJogadas / 3;
	}

	public boolean isUltimoAndarCompleto() {
		return contadorJogadas % 3 == 0;
	}

	public boolean isTorreDestruida() {
		return torreDestruida;
	}

	public void reconstruirTorre() {
		if (!torreDestruida) throw new IllegalStateException("Torre ja' esta' em pe'");
		levarAoEstadoInicial();
	}

	private void levarAoEstadoInicial() {
		torreDestruida = false;
		contadorJogadas = 0;
	}

	private void fazerMovimento() {
		if (torreDestruida) throw new IllegalStateException("Fazer movimento so' e' valido com torre em pe'");
		++contadorJogadas;
	}

	public void setSorteadorResultado(Random random) {
		this.random = random;
	}

	public void fazerMovimentoSorteando() {
		if (random.nextBoolean()) {
			fazerMovimentoCerto();
		} else {
			fazerMovimentoErrado();
		}
	}
	
}
