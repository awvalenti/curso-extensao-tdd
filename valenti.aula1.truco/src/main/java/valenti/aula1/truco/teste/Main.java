package valenti.aula1.truco.teste;

import valenti.aula1.truco.implementacoes.SaidaJogoNoConsole;
import valenti.aula1.truco.modelo.Jogador;
import valenti.aula1.truco.modelo.Partida;

public class Main {

	public static void main(String[] args) {
		Partida partida = new Partida(new SaidaJogoNoConsole());

		Jogador tadeu = new Jogador("Tadeu", partida);
		Jogador sergio = new Jogador("Sergio", partida);
		partida.iniciarJogo(tadeu, sergio);

		tadeu.lancarCartaNaMesa(0);
		sergio.lancarCartaNaMesa(1);
	}
}
