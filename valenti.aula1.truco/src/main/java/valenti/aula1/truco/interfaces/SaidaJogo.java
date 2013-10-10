package valenti.aula1.truco.interfaces;

import valenti.aula1.truco.modelo.Carta;
import valenti.aula1.truco.modelo.ColecaoCartas;
import valenti.aula1.truco.modelo.Jogador;
import valenti.aula1.truco.modelo.resultadorodada.ResultadoRodada;

public interface SaidaJogo {

	void inicioRodadaGrande();

	void atualizacaoRodadaPequena(Jogador jogadorAtual);

	void lancamentoCarta(Jogador jogador, Carta carta, ColecaoCartas mesa);

	void finalizacaoRodadaPequena(ResultadoRodada resultado);

}
