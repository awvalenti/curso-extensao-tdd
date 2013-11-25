package tdd.reservasala.domain;

public class Reserva {

	private final Sala sala;
	private final int horaInicio;
	private final int horaFim;

	public Reserva(Sala sala, int horaInicio, int horaFim) {
		this.sala = sala;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Reserva)) return false;

		Reserva r = (Reserva) obj;

		return sala.equals(r.sala) && horaInicio == r.horaInicio && horaFim == r.horaFim;
	}

	@Override
	public int hashCode() {
		return horaInicio + 10 * horaFim;
	}

}
