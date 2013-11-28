package tdd.reservasala.domain;

public class Reserva {

	private final Usuario usuario;
	private final Sala sala;
	private final int horaInicio;
	private final int horaFim;

	public Reserva(Usuario usuario, Sala sala, int horaInicio, int horaFim) {
		this.usuario = usuario;
		this.sala = sala;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Reserva)) return false;

		Reserva outra = (Reserva) obj;

		return usuario.equals(outra.usuario) && sala.equals(outra.sala) && horaInicio == outra.horaInicio && horaFim == outra.horaFim;
	}

	@Override
	public int hashCode() {
		return horaInicio + 10 * horaFim;
	}

	@Override
	public String toString() {
		return sala + ", de " + horaInicio + "h a " + horaFim + "h";
	}

}
