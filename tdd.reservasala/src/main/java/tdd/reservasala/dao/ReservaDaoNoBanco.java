package tdd.reservasala.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import tdd.reservasala.domain.Reserva;
import tdd.reservasala.domain.Sala;

public class ReservaDaoNoBanco implements ReservaDao {

	private final EntityManagerFactory emf;

	public ReservaDaoNoBanco(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void incluir(Reserva reserva) {
		EntityManager em = em();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(reserva);
		tx.commit();
	}

	@Override
	public void excluir(Reserva reserva) {
		EntityManager em = em();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.getReference(Reserva.class, reserva.getId()));
		tx.commit();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Reserva> buscarTodas() {
		return em().createQuery("FROM Reserva").getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Reserva> buscarReservasConflitantes(Sala sala, int horaInicio, int horaFim) {
		return em().createQuery(""
				+ "FROM Reserva"
				+ " WHERE sala = :sala AND ("
				+ " :horaInicio BETWEEN horaInicio AND horaFim"
				+ " OR"
				+ " :horaFim BETWEEN horaInicio AND horaFim"
				+ ")")
				.setParameter("sala", sala)
				.setParameter("horaInicio", horaInicio)
				.setParameter("horaFim", horaFim)
				.getResultList();
	}

	private EntityManager em() {
		return emf.createEntityManager();
	}

}
