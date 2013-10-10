package valenti.aula1.truco.modelo;

import static valenti.aula1.truco.modelo.Carta.*;
import valenti.aula1.truco.modelo.resultadorodada.ResultadoRodada;

public class ArranjoBaralho {

	private ColecaoCartas baralho;

	private ColecaoCartas monte;
	private Mesa mesa;
	private Carta cartaVirada;

	public ArranjoBaralho(int numeroJogadores) {
		baralho = new ColecaoCartas(AS, DOIS, TRES, QUATRO, CINCO, SEIS, SETE, DAMA, VALETE, REI, AS, DOIS, TRES);
		monte = new ColecaoCartas();
		mesa = new Mesa(numeroJogadores);
	}

	public void iniciarRodadaGrande(RodaJogadores rodaJogadores) {
		monte.comprarTodasDe(baralho);

		for (Jogador jogador : rodaJogadores) {
			jogador.comprar(3, monte);
		}

		cartaVirada = monte.retirarUma();
	}

	public void finalizarRodadaGrande(RodaJogadores rodaJogadores) {
		for (Jogador jogador : rodaJogadores) {
			baralho.comprarTodasDe(jogador.getMao());
		}
		baralho.comprarTodasDe(monte, mesa);
		baralho.acrescentar(cartaVirada);
		baralho.embaralhar();
	}

	public void jogadorLancarCarta(Carta carta) {
		mesa.acrescentar(carta);
	}

	public ColecaoCartas getMesa() {
		return mesa.gerarCopiaImutavel();
	}

	public boolean rodadaPequenaTerminou() {
		return mesa.estahCompleta();
	}

	public ResultadoRodada calcularResultadoRodadaPequena() {
		return mesa.calcularResultadoRodadaPequena();
	}

}
