package tdd.truco.nucleo;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static tdd.truco.nucleo.resultado.FabricaResultado.*;

import org.junit.Before;
import org.junit.Test;

import tdd.truco.nucleo.resultado.Resultado;

public class RodadaTest {

	private Jogador jorge;
	private Jogador amanda;
	private EstadoCiclos estadoCiclos;
	private Rodada rodada;

	@Before
	public void setUp() {
		jorge = new Jogador("Jorge");
		amanda = new Jogador("Amanda");
		estadoCiclos = mock(EstadoCiclos.class);
		rodada = new Rodada(estadoCiclos);
	}

	@Test
	public void deve_estar_em_andamento_quando_tiver_menos_de_dois_ciclos() {
		when(estadoCiclos.getQuantidadeCiclos()).thenReturn(0);
		assertThat(rodada.calcularResultado(), is(emAndamento()));

		when(estadoCiclos.getQuantidadeCiclos()).thenReturn(1);
		assertThat(rodada.calcularResultado(), is(emAndamento()));
	}

	@Test
	public void deve_estar_em_andamento_quando_tiver_dois_ciclos_com_vencedores_diferentes() {
		when(estadoCiclos.getQuantidadeCiclos()).thenReturn(2);
		when(estadoCiclos.calcularResultadoDoCiclo(0)).thenReturn(vencedor(jorge));
		when(estadoCiclos.calcularResultadoDoCiclo(1)).thenReturn(vencedor(amanda));
		assertThat(rodada.calcularResultado(), is(emAndamento()));
	}

	@Test
	public void deve_estar_em_andamento_quando_tiver_dois_ciclos_empatados() {
		when(estadoCiclos.getQuantidadeCiclos()).thenReturn(2);
		when(estadoCiclos.calcularResultadoDoCiclo(0)).thenReturn(empate());
		when(estadoCiclos.calcularResultadoDoCiclo(1)).thenReturn(empate());
		assertThat(rodada.calcularResultado(), is(emAndamento()));
	}

	@Test
	public void deve_terminar_com_vencedor_quando_tiver_dois_ciclos_com_mesmo_vencedor() {
		when(estadoCiclos.getQuantidadeCiclos()).thenReturn(2);
		when(estadoCiclos.calcularResultadoDoCiclo(0)).thenReturn(vencedor(jorge));
		when(estadoCiclos.calcularResultadoDoCiclo(1)).thenReturn(vencedor(jorge));
		assertThat(rodada.calcularResultado(), is(vencedor(jorge)));
	}

	@Test
	public void deve_terminar_com_vencedor_quando_tiver_tres_ciclos() {
		when(estadoCiclos.getQuantidadeCiclos()).thenReturn(3);
		when(estadoCiclos.calcularResultadoDoCiclo(0)).thenReturn(vencedor(amanda));
		when(estadoCiclos.calcularResultadoDoCiclo(1)).thenReturn(vencedor(jorge));
		when(estadoCiclos.calcularResultadoDoCiclo(2)).thenReturn(vencedor(amanda));
		assertThat(rodada.calcularResultado(), is(vencedor(amanda)));
	}

	@Test
	public void deve_terminar_com_empate_quando_tres_ciclos_terminarem_empatados() {
		assertThat(paraCiclosResultandoEm(empate(), empate(), empate()), is(empate()));
	}

	private Resultado paraCiclosResultandoEm(Resultado... resultados) {
		when(estadoCiclos.getQuantidadeCiclos()).thenReturn(resultados.length);

		for (int i = 0; i < resultados.length; ++i) {
			when(estadoCiclos.calcularResultadoDoCiclo(i)).thenReturn(resultados[i]);
		}

		return rodada.calcularResultado();
	}

}
