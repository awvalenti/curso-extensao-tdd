package valenti.aula1.truco.modelo;

import valenti.aula1.truco.interfaces.EntradaJogo;
import valenti.aula1.truco.interfaces.SaidaJogo;
import valenti.aula1.truco.modelo.resultadorodada.ResultadoRodada;

public class Partida implements EntradaJogo {

	private RodaJogadores rodaJogadores;
	private ArranjoBaralho arranjoBaralho;
	private SaidaJogo saida;

	public Partida(SaidaJogo saida) {
		this.saida = saida;
	}

	public void iniciarJogo(Jogador... jogadores) {
		this.rodaJogadores = new RodaJogadores(jogadores);
		this.arranjoBaralho = new ArranjoBaralho(jogadores.length);

		iniciarRodadaGrande();
	}

	private void iniciarRodadaGrande() {
		arranjoBaralho.iniciarRodadaGrande(rodaJogadores);
		saida.inicioRodadaGrande();

		saida.atualizacaoRodadaPequena(rodaJogadores.getJogadorAtual());
	}

	@Override
	public void lancarCartaNaMesa(Jogador jogador, int indiceCarta) {
		if (rodaJogadores.getJogadorAtual().equals(jogador)) {
			Carta carta = jogador.retirarCarta(indiceCarta);
			arranjoBaralho.jogadorLancarCarta(carta);
			saida.lancamentoCarta(jogador, carta, arranjoBaralho.getMesa());

			if (arranjoBaralho.rodadaPequenaTerminou()) {
				ResultadoRodada resultado = arranjoBaralho.calcularResultadoRodadaPequena();
				saida.finalizacaoRodadaPequena(resultado);

			} else {
				rodaJogadores.moverParaProximo();
				saida.atualizacaoRodadaPequena(rodaJogadores.getJogadorAtual());
			}
		}
	}

}
