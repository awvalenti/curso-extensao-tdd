package tdd.reservasala.dao;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tdd.reservasala.domain.Reserva;
import tdd.reservasala.domain.Sala;
import tdd.reservasala.domain.Usuario;

public class ReservaDaoNoBancoTest {

	private static EntityManagerFactory emf;

	private Usuario usuario;
	private ReservaDao reservaDao;
	private SalaDao salaDao;

	@BeforeClass
	public static void setUpClass() {
		emf = Persistence.createEntityManagerFactory("banco-em-memoria");
	}

	@AfterClass
	public static void tearDownClass() {
		emf.close();
	}

	@Before
	public void setUp() {
		UsuarioDao usuarioDao = new UsuarioDaoNoBanco(emf);
		usuario = Usuario.criarUsuarioSimples();
		usuarioDao.incluir(usuario);

		reservaDao = new ReservaDaoNoBanco(emf);
		salaDao = new SalaDaoNoBanco(emf);

		salaDao.incluir(new Sala("Sala 1"));
		salaDao.incluir(new Sala("Sala 2"));
	}

	@Test
	public void deve_iniciar_sem_reservas() {
		assertThat(reservaDao.buscarTodas(), is(empty()));
	}

	@Test
	public void deve_incluir_reserva() {
		Reserva novaReserva = new Reserva(usuario, salaDao.buscarPorId(1), 10, 12);
		reservaDao.incluir(novaReserva);
		assertThat(reservaDao.buscarTodas(), contains(novaReserva));
	}

	@Test
	public void deve_excluir_reserva() {
		Reserva novaReserva = new Reserva(usuario, salaDao.buscarPorId(2), 14, 18);
		reservaDao.incluir(novaReserva);
		reservaDao.excluir(novaReserva);
		assertThat(reservaDao.buscarTodas(), is(empty()));
	}

}
