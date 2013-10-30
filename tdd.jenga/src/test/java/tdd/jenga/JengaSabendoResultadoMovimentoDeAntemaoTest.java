package tdd.jenga;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class JengaSabendoResultadoMovimentoDeAntemaoTest {

	private Jenga jenga;

	@Before
	public void setUp() {
		jenga = new Jenga();
	}

	@Test
	public void deveIniciarCom20AndaresCompletosEComTorreEmPe() {
		verificarEstadoInicial();
	}

	private void verificarEstadoInicial() {
		assertThat(jenga.isUltimoAndarCompleto(), is(true));
		assertThat(jenga.getNumeroAndaresCompletos(), is(18));
		assertThat(jenga.isTorreDestruida(), is(false));
	}
	
	@Test
	public void umOuDoisMovimentosDevemDeixarUltimoAndarIncompleto() {
		jenga.fazerMovimentoCerto();
		assertThat(jenga.isUltimoAndarCompleto(), is(false));
		assertThat(jenga.getNumeroAndaresCompletos(), is(18));
		
		jenga.fazerMovimentoCerto();
		assertThat(jenga.isUltimoAndarCompleto(), is(false));
		assertThat(jenga.getNumeroAndaresCompletos(), is(18));
	}

	@Test
	public void tresMovimentosCertosDevemCompletarNovoAndar() {
		jenga.fazerMovimentoCerto();
		jenga.fazerMovimentoCerto();
		jenga.fazerMovimentoCerto();
		assertThat(jenga.isUltimoAndarCompleto(), is(true));
		assertThat(jenga.getNumeroAndaresCompletos(), is(19));
	}
	
	@Test
	public void umMovimentoErradoDeveDerrubarATorre() {
		jenga.fazerMovimentoErrado();
		assertThat(jenga.isTorreDestruida(), is(true));
	}
	
	@Test
	public void devePermitirReconstruirTorre() {
		jenga.fazerMovimentoErrado();
		jenga.reconstruirTorre();
		verificarEstadoInicial();
	}
	
	@Test(expected = IllegalStateException.class)
	public void deveProibirReconstruirTorreEmPe() {
		jenga.reconstruirTorre();
	}
	
	@Test(expected = IllegalStateException.class)
	public void deveProibirMovimentoCertoComTorreEmPe() {
		jenga.fazerMovimentoErrado();
		jenga.fazerMovimentoCerto();
	}
	
	@Test
	public void deveManterRecordeDeAltura() {
		
	}
	
}
