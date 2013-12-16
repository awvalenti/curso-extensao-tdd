package tdd.truco.nucleo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class EstadoJogadasTest {

	private Jogador amanda;
	private EstadoJogadas estadoJogadas;

	@Before
	public void setUp() {
		amanda = new Jogador("Amanda");
		estadoJogadas = new EstadoJogadas();
	}

	@Test
	public void deve_receber_jogadas() {
		Jogada jogada = new Jogada(amanda, Carta.AS);
		estadoJogadas.acrescentarJogada(jogada);
		assertThat(estadoJogadas.getJogadas(), contains(jogada));
	}

}
