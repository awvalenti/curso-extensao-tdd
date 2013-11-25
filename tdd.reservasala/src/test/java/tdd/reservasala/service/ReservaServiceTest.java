package tdd.reservasala.service;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import tdd.reservasala.domain.Reserva;
import tdd.reservasala.domain.Sala;
import tdd.reservasala.domain.SalaDao;
import tdd.reservasala.service.exception.SalaJaReservadaException;

public class ReservaServiceTest {

	private ReservaService reservaService;
	private ReservaDao reservaDao;
	private SalaDao salaDao;

	private Sala salaLivre;
	private Sala salaOcupada;

	@Before
	public void setUp() {
		salaLivre = new Sala();
		salaOcupada = new Sala();

		salaDao = mock(SalaDao.class);
		when(salaDao.buscarPorId(1L)).thenReturn(salaLivre);
		when(salaDao.buscarPorId(2L)).thenReturn(salaOcupada);

		reservaDao = mock(ReservaDao.class);
		when(reservaDao.salaEstaLivre(1L, 8, 10)).thenReturn(true);
		when(reservaDao.salaEstaLivre(2L, 14, 18)).thenReturn(false);

		reservaService = new ReservaService(reservaDao, salaDao);
	}

	@Test
	public void deve_reservar_sala_livre() {
		reservaService.reservar(1L, 8, 10, false);
		verify(reservaDao).incluir(new Reserva(salaLivre, 8, 10));
	}

	@Test(expected = SalaJaReservadaException.class)
	public void nao_deve_reservar_sala_ocupada_se_nao_tiver_privilegio() {
		reservaService.reservar(2L, 14, 18, false);
	}

	@Test
	public void deve_reservar_sala_ocupada_se_tiver_privilegio() {
		reservaService.reservar(2L, 14, 18, true);
		verify(reservaDao).excluir(new Reserva(salaOcupada, 14, 18));
		verify(reservaDao).incluir(new Reserva(salaOcupada, 14, 18));
	}
}
