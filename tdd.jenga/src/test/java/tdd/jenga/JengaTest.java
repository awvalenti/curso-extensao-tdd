package tdd.jenga;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class JengaTest {

	private Jenga jenga;

	@Before
	public void setUp() {
		jenga = new Jenga();
	}

	@Test
	public void umOuDoisMovimentosDevemDeixarUltimoAndarIncompleto() {
		jenga.setSorteadorResultado(null);
		
		jenga.fazerMovimentoSorteando();
		assertThat(jenga.isUltimoAndarCompleto(), is(false));
		assertThat(jenga.getNumeroAndaresCompletos(), is(18));
		
		jenga.fazerMovimentoSorteando();
		assertThat(jenga.isUltimoAndarCompleto(), is(false));
		assertThat(jenga.getNumeroAndaresCompletos(), is(18));
	}

}
