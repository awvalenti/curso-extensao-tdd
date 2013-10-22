package tdd.katas;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class IntervaloTest {

	private Intervalo zeroADez;

	@Before
	public void setUp() {
		zeroADez = Intervalo.abertoNoInicioFechadoNoFim(0, 10);
	}

	@Test
	public void deveReconhecerLimites() {
		assertThat(zeroADez.contem(0), is(true));
		assertThat(zeroADez.contem(10), is(false));
	}

	@Test
	public void deveReconhecerInternos() {
		assertThat(zeroADez.contem(4), is(true));
	}

	@Test
	public void deveReconhecerExternos() {
		assertThat(zeroADez.contem(-1), is(false));
		assertThat(zeroADez.contem(11), is(false));
	}

	@Test
	public void deveCalcularIntersecoes() {
		assertThat(zeroADez.intersecaoCom(Intervalo.abertoNoInicioFechadoNoFim(2, 5)),
				is(Intervalo.abertoNoInicioFechadoNoFim(2, 5)));
	}

}
