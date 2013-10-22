package tdd.katas;

public class Intervalo {

	private int inicio;
	private int fim;

	private Intervalo(int inicio, int fim) {
		this.inicio = inicio;
		this.fim = fim;
	}

	public static Intervalo abertoNoInicioFechadoNoFim(int inicio, int fim) {
		return new Intervalo(inicio, fim);
	}

	public boolean contem(int valor) {
		return inicio <= valor && valor < fim;
	}

	public Intervalo intersecaoCom(Intervalo outro) {
		return outro;
	}

	@Override
	public String toString() {
		return "[" + inicio + ", " + fim + ')';
	}

	@Override
	public boolean equals(Object outro) {
		return inicio == ((Intervalo) outro).inicio && fim == ((Intervalo) outro).fim;
	}

	@Override
	public int hashCode() {
		return inicio + 2 * fim;
	}

}
