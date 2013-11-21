package tdd.truco;

public class Jogador {

	private final String nome;

	public Jogador(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

}
