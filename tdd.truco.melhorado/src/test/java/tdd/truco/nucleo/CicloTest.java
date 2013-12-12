package tdd.truco.nucleo;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static tdd.truco.nucleo.Carta.*;
import static tdd.truco.nucleo.resultado.FabricaResultado.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import tdd.truco.nucleo.resultado.Resultado;

public class CicloTest {

	private Jogador jorge;
	private Jogador amanda;
	private EstadoJogadas estadoJogadas;
	private Ciclo ciclo;

	@Before
	public void setUp() {
		jorge = new Jogador("Jorge");
		amanda = new Jogador("Amanda");
		estadoJogadas = mock(EstadoJogadas.class);
		ciclo = new Ciclo(estadoJogadas, 2);
	}

	@Test
	public void deve_estar_em_andamento_quando_nem_todos_os_jogadores_tiverem_jogado() {
		assertThat(paraNenhumaJogada(), is(emAndamento()));
		assertThat(paraUmaJogada(de(amanda, AS)), is(emAndamento()));
	}

	@Test
	public void deve_terminar_com_empate_quando_todos_jogadores_jogarem_e_cartas_empatarem() {
		assertThat(paraJogadas(de(jorge, AS), de(amanda, AS)), is(empate()));
	}

	@Test
	public void deve_terminar_com_vencedor_quando_todos_jogadores_jogarem_e_houver_maior_carta() {
		assertThat(paraJogadas(de(jorge, TRES), de(amanda, DOIS)), is(vencedor(jorge)));
	}

	private Resultado paraNenhumaJogada() {
		return paraJogadas();
	}

	private Resultado paraUmaJogada(Jogada jogada) {
		return paraJogadas(jogada);
	}

	private Resultado paraJogadas(Jogada... jogadas) {
		when(estadoJogadas.getJogadas()).thenReturn(Arrays.asList(jogadas));
		return ciclo.calcularResultado();
	}

	private Jogada de(Jogador jogador, Carta carta) {
		return new Jogada(jogador, carta);
	}

}
