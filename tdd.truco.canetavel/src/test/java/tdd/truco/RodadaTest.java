package tdd.truco;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class RodadaTest {

	private Rodada rodada;
	private Jogador jose;
	private Jogador maria;

	@Before
	public void setUp() {
		jose = new Jogador("Jose");
		maria = new Jogador("Maria");
	}

	@Test
	public void deve_estar_em_andamento_quando_tiver_um_ciclo_em_andamento() {
		rodada = rodadaCom(cicloEmAndamento());
		assertThat(rodada.terminou(), is(false));
	}

	@Test
	public void deve_estar_em_andamento_quando_tiver_um_ciclo_terminado() {
		rodada = rodadaCom(cicloVencidoPor(jose));
		assertThat(rodada.terminou(), is(false));
	}

	@Test
	public void deve_estar_em_andamento_quando_dois_ciclos_terminarem_com_vencedores_diferentes() {
		rodada = rodadaCom(cicloVencidoPor(jose), cicloVencidoPor(maria));
		assertThat(rodada.terminou(), is(false));
	}

	@Test
	public void deve_terminar_quando_dois_ciclos_terminarem_com_mesmo_vencedor() {
		rodada = rodadaCom(cicloVencidoPor(jose), cicloVencidoPor(jose));
		assertThat(rodada.terminou(), is(true));
	}

	@Test
	public void deve_terminar_quando_tres_ciclos_terminarem() {
		rodada = rodadaCom(cicloVencidoPor(jose), cicloVencidoPor(maria), cicloVencidoPor(maria));
		assertThat(rodada.terminou(), is(true));
	}

	@Test
	public void deve_calcular_vencedor_com_dois_ciclos() {
		rodada = rodadaCom(cicloVencidoPor(jose), cicloVencidoPor(jose));
		assertThat(rodada.calcularVencedor(), is(jose));
	}

	@Test
	public void deve_calcular_vencedor_com_tres_ciclos() {
		rodada = rodadaCom(cicloVencidoPor(jose), cicloVencidoPor(maria), cicloVencidoPor(maria));
		assertThat(rodada.calcularVencedor(), is(maria));
	}

	private static Rodada rodadaCom(Ciclo... ciclos) {
		return new Rodada(Arrays.asList(ciclos));
	}

	private static Ciclo cicloEmAndamento() {
		Ciclo ciclo = mock(Ciclo.class);
		when(ciclo.terminou()).thenReturn(false);
		return ciclo;
	}

	private static Ciclo cicloVencidoPor(Jogador jogador) {
		Ciclo ciclo = mock(Ciclo.class);
		when(ciclo.terminou()).thenReturn(true);
		when(ciclo.calcularVencedor()).thenReturn(jogador);
		return ciclo;
	}

}
