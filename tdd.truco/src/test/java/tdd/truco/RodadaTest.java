package tdd.truco;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class RodadaTest {

	private Rodada rodada;
	private Ciclo ciclo1;
	private Ciclo ciclo2;
	private Ciclo ciclo3;
	private Jogador jogador1;
	private Jogador jogador2;

	@Before
	public void setUp() {
		ciclo1 = mock(Ciclo.class);
		ciclo2 = mock(Ciclo.class);
		ciclo3 = mock(Ciclo.class);

		jogador1 = new Jogador("Jogador 1");
		jogador2 = new Jogador("Jogador 2");
	}

	@Test
	public void deve_estar_em_andamento_quando_tiver_somente_um_ciclo() {
		rodada = new Rodada(Arrays.asList(ciclo1));
		assertThat(rodada.terminou(), is(false));
	}

	@Test
	public void deve_estar_em_andamento_quando_dois_ciclos_terminarem_com_vencedores_diferentes() {
		when(ciclo1.terminou()).thenReturn(true);
		when(ciclo2.terminou()).thenReturn(true);
		when(ciclo1.calcularVencedor()).thenReturn(jogador1);
		when(ciclo2.calcularVencedor()).thenReturn(jogador2);

		rodada = new Rodada(Arrays.asList(ciclo1, ciclo2));
		assertThat(rodada.terminou(), is(false));
	}

	@Test
	public void deve_terminar_quando_dois_ciclos_terminarem_com_mesmo_vencedor() {
		when(ciclo1.calcularVencedor()).thenReturn(jogador1);
		when(ciclo2.calcularVencedor()).thenReturn(jogador1);

		rodada = new Rodada(Arrays.asList(ciclo1, ciclo2));
		assertThat(rodada.terminou(), is(true));
	}

	@Test
	public void deve_terminar_quando_tres_ciclos_terminarem() {
		when(ciclo1.terminou()).thenReturn(true);
		when(ciclo2.terminou()).thenReturn(true);
		when(ciclo3.terminou()).thenReturn(true);

		rodada = new Rodada(Arrays.asList(ciclo1, ciclo2, ciclo3));
		assertThat(rodada.terminou(), is(true));
	}

}
