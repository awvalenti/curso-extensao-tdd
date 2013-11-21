package tdd.truco;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CicloTest {

	private Ciclo ciclo;
	private SaidaJogo saida;
	private Jogador jogador1;
	private Jogador jogador2;
	private Carta dama;
	private Carta rei;

	@Before
	public void setUp() {
		jogador1 = new Jogador("Jogador 1");
		jogador2 = new Jogador("Jogador 2");
		dama = Carta.DAMA;
		rei = Carta.REI;
		saida = mock(SaidaJogo.class);
		ciclo = new Ciclo(saida, new ArrayList<Jogada>());
	}

	@Test
	public void deve_informar_jogada_ao_recebe_la_e_indicar_estar_em_andamento() {
		ciclo.fazerJogada(jogador1, dama);

		verify(saida).aoFazerJogada(jogador1, dama);
		assertThat(ciclo.terminou(), is(false));
	}

	@Test(expected = IllegalStateException.class)
	public void deve_rejeitar_jogadas_seguidas_do_mesmo_jogador() {
		ciclo.fazerJogada(jogador1, dama);
		ciclo.fazerJogada(jogador1, rei);
	}

	@Test
	public void deve_terminar_e_informar_vencedor_do_ciclo() {
		ciclo.fazerJogada(jogador1, dama);
		ciclo.fazerJogada(jogador2, rei);

		verify(saida).aoTerminarCiclo(jogador2);
		assertThat(ciclo.terminou(), is(true));
	}

}
