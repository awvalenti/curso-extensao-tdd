package tdd.reservasala.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Sala sala;

	@ManyToOne
	private Usuario usuario;

	private int horaInicio;
	private int horaFim;

	public Reserva() {
	}

	public Reserva(Usuario usuario, Sala sala, int horaInicio, int horaFim) {
		this.usuario = usuario;
		this.sala = sala;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + horaFim;
		result = prime * result + horaInicio;
		result = prime * result + ((sala == null) ? 0 : sala.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (horaFim != other.horaFim)
			return false;
		if (horaInicio != other.horaInicio)
			return false;
		if (sala == null) {
			if (other.sala != null)
				return false;
		} else if (!sala.equals(other.sala))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return sala + ", de " + horaInicio + "h a " + horaFim + "h, para " + usuario;
	}

	public Sala getSala() {
		return sala;
	}

}
