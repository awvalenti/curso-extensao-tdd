package tdd.katas;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class ListaArquivosRecentesTest {

	private ListaArquivosRecentes lista;

	@Before
	public void setUp() {
		lista = new ListaArquivosRecentes(3);
	}

	@Test
	public void deveComecarVazia() {
		assertThat(lista.estahVazia(), is(true));
	}

	@Test
	public void deveIncluirItensDiferentes() {
		lista.adicionar("1.txt");
		assertThat(lista.estahVazia(), is(false));
		assertThat(lista, contains("1.txt"));

		lista.adicionar("2.txt");
		assertThat(lista, contains("2.txt", "1.txt"));

		lista.adicionar("3.txt");
		assertThat(lista, contains("3.txt", "2.txt", "1.txt"));
	}

	@Test
	public void deveTrazerItemRepetidoDeVoltaAoTopoDaLista() {
		lista.adicionar("1.txt");
		lista.adicionar("2.txt");
		lista.adicionar("3.txt");
		assertThat(lista, contains("3.txt", "2.txt", "1.txt"));

		lista.adicionar("1.txt");
		assertThat(lista, contains("1.txt", "3.txt", "2.txt"));
	}

	@Test
	public void deveDescartarItemMaisAntigoAposExcederTamanhoLimite() {
		lista.adicionar("1.txt");
		lista.adicionar("2.txt");
		lista.adicionar("3.txt");
		lista.adicionar("4.txt");
		assertThat(lista, contains("4.txt", "3.txt", "2.txt"));
	}

}
