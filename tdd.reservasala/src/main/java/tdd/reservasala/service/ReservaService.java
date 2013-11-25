package tdd.reservasala.service;

import tdd.reservasala.domain.Reserva;
import tdd.reservasala.domain.SalaDao;
import tdd.reservasala.service.exception.SalaJaReservadaException;

public class ReservaService {

	private final ReservaDao reservaDao;
	private final SalaDao salaDao;

	public ReservaService(ReservaDao reservaDao, SalaDao salaDao) {
		this.reservaDao = reservaDao;
		this.salaDao = salaDao;
	}

	public void reservar(long salaId, int horaInicio, int horaFim, boolean temPrivilegio) {
		if (!reservaDao.salaEstaLivre(salaId, horaInicio, horaFim)) {
			if (temPrivilegio) reservaDao.excluir(null);
			else throw new SalaJaReservadaException();
		}

		reservaDao.incluir(new Reserva(salaDao.buscarPorId(salaId), horaInicio, horaFim));
	}

}
