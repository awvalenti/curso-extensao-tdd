package tdd.reservasala.service;

import tdd.reservasala.domain.Reserva;

public interface ReservaDao {

	public void incluir(Reserva reserva);

	boolean salaEstaLivre(long salaId, int horaInicio, int horaFim);

	void excluir(Reserva reserva);

}
