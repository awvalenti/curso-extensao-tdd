package tdd.reservasala.service;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import tdd.reservasala.dao.ReservaDao;
import tdd.reservasala.dao.SalaDao;
import tdd.reservasala.domain.Reserva;
import tdd.reservasala.domain.Sala;
import tdd.reservasala.domain.Usuario;
import tdd.reservasala.service.exception.SalaJaReservadaException;

public class ReservaServiceTest {

	private Usuario usuarioSimples;
	private Usuario superUsuario;

	private Sala sala1;
	private Sala sala2;
	private Reserva reservaPrevia;

	private ReservaService reservaService;
	private ReservaDao reservaDao;
	private SalaDao salaDao;

	@Before
	public void setUp() {
		usuarioSimples = Usuario.criarUsuarioSimples();
		superUsuario = Usuario.criarSuperUsuario();

		sala1 = new Sala("Sala1");
		sala2 = new Sala("Sala2");

		salaDao = mock(SalaDao.class);
		when(salaDao.buscarPorId(1L)).thenReturn(sala1);
		when(salaDao.buscarPorId(2L)).thenReturn(sala2);

		reservaPrevia = new Reserva(usuarioSimples, sala2, 8, 18);

		reservaDao = mock(ReservaDao.class);
		when(reservaDao.buscarReservasConflitantes(eq(sala1), anyInt(), anyInt())).thenReturn(Collections.<Reserva>emptyList());
		when(reservaDao.buscarReservasConflitantes(eq(sala2), anyInt(), anyInt())).thenReturn(Arrays.asList(reservaPrevia));

		reservaService = new ReservaService(reservaDao, salaDao);
	}

	@Test
	public void deve_reservar_sala_livre() {
		reservaService.reservar(1L, 10, 11, usuarioSimples);
		verify(reservaDao).incluir(new Reserva(usuarioSimples, sala1, 10, 11));
	}

	@Test(expected = SalaJaReservadaException.class)
	public void nao_deve_reservar_sala_ocupada_se_nao_tiver_privilegio() {
		reservaService.reservar(2L, 14, 16, usuarioSimples);
	}

	@Test
	public void deve_reservar_sala_ocupada_se_tiver_privilegio() {
		reservaService.reservar(2L, 14, 16, superUsuario);
		verify(reservaDao).excluir(reservaPrevia);
		verify(reservaDao).incluir(new Reserva(superUsuario, sala2, 14, 16));
	}
}
