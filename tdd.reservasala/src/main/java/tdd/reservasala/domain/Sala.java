package tdd.reservasala.domain;

public class Sala {

	private String nome;

	public Sala(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

}
