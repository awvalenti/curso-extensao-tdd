package tdd.reservasala.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tdd.reservasala.dao.ReservaDao;
import tdd.reservasala.dao.SalaDao;
import tdd.reservasala.domain.Reserva;
import tdd.reservasala.domain.Sala;
import tdd.reservasala.domain.Usuario;
import tdd.reservasala.service.exception.SalaJaReservadaException;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class ReservaService {

	private final ReservaDao reservaDao;
	private final SalaDao salaDao;

	public ReservaService(ReservaDao reservaDao, SalaDao salaDao) {
		this.reservaDao = reservaDao;
		this.salaDao = salaDao;
	}

	public void reservar(long salaId, int horaInicio, int horaFim, Usuario usuario) {
		Sala sala = salaDao.buscarPorId(salaId);

		List<Reserva> conflitos = reservaDao.buscarReservasConflitantes(sala, horaInicio, horaFim);

		if (!conflitos.isEmpty()) {
			if (!usuario.temPrivilegio()) {
				throw new SalaJaReservadaException();
			} else {
				for (Reserva conflito : conflitos) {
					reservaDao.excluir(conflito);
				}
			}
		}

		reservaDao.incluir(new Reserva(usuario, sala, horaInicio, horaFim));
	}
	
	public Map<Long, Reserva> buscarReservasPorIdSala(long salaId) {
		Map<Long, Reserva> reservas = new HashMap<>();
		
		for (Reserva reserva : reservaDao.buscarTodas()) {
			reservas.put(reserva.getSala().getId(), reserva);
		}
		
		return reservas;
	}

}
