package tdd.reservasala.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	public Sala() {
	}

	public Sala(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Sala && id == ((Sala) obj).id;
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.intValue();
	}

}
