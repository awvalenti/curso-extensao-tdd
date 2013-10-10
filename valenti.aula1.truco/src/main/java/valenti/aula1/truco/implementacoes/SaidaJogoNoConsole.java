package valenti.aula1.truco.implementacoes;

import valenti.aula1.truco.interfaces.SaidaJogo;
import valenti.aula1.truco.modelo.Carta;
import valenti.aula1.truco.modelo.ColecaoCartas;
import valenti.aula1.truco.modelo.Jogador;
import valenti.aula1.truco.modelo.resultadorodada.ResultadoRodada;

public class SaidaJogoNoConsole implements SaidaJogo {

	@Override
	public void inicioRodadaGrande() {
		System.out.println("Inicio de rodada grande");
	}

	@Override
	public void lancamentoCarta(Jogador jogador, Carta carta, ColecaoCartas mesa) {
		System.out.println(jogador + " lancou " + carta + " na mesa. Mesa agora esta assim: " + mesa);
	}

	@Override
	public void atualizacaoRodadaPequena(Jogador jogadorAtual) {
		System.out.println("Vez de " + jogadorAtual);
	}

	@Override
	public void finalizacaoRodadaPequena(ResultadoRodada resultado) {
		System.out.println("Rodada pequena finalizada. Resultado: " + resultado);
	}

}
