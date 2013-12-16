package tdd.truco.nucleo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class EstadoCiclosTest {

	private Jogador jorge;
	private Jogador amanda;
	private EstadoCiclos estadoCiclos;

	@Before
	public void setUp() {
		jorge = new Jogador("Jorge");
		amanda = new Jogador("Amanda");
		estadoCiclos = new EstadoCiclos(2);
	}

	@Test
	public void deve_iniciar_sem_ciclos() {
		assertThat(estadoCiclos.getQuantidadeCiclos(), is(0));
	}

	@Test
	public void deve_abrir_primeiro_ciclo_ao_incluir_primeira_jogada() {
		estadoCiclos.incluirJogada(new Jogada(amanda, Carta.AS));
		assertThat(estadoCiclos.getQuantidadeCiclos(), is(1));
	}

	@Test
	public void deve_continuar_no_primeiro_ciclo_apos_todos_jogarem() {
		estadoCiclos.incluirJogada(new Jogada(amanda, Carta.AS));
		estadoCiclos.incluirJogada(new Jogada(jorge, Carta.AS));
		assertThat(estadoCiclos.getQuantidadeCiclos(), is(1));
	}

	@Test
	public void deve_abrir_segundo_ciclo_apos_todos_jogarem_e_comecar_nova_rodada() {
		estadoCiclos.incluirJogada(new Jogada(amanda, Carta.AS));
		estadoCiclos.incluirJogada(new Jogada(jorge, Carta.AS));
		estadoCiclos.incluirJogada(new Jogada(amanda, Carta.AS));
		assertThat(estadoCiclos.getQuantidadeCiclos(), is(2));
	}

}
