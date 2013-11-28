package tdd.reservasala.dao;

import java.util.List;

import tdd.reservasala.domain.Reserva;
import tdd.reservasala.domain.Sala;

public interface ReservaDao {

	void incluir(Reserva reserva);

	void excluir(Reserva reserva);

	List<Reserva> buscarReservasConflitantes(Sala sala, int horaInicio, int horaFim);

}
