package tdd.reservasala.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import br.com.caelum.vraptor.ioc.Component;
import tdd.reservasala.domain.Sala;

@Component
public class SalaDaoNoBanco implements SalaDao {

	private final EntityManagerFactory emf;

	public SalaDaoNoBanco(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Sala> buscarTodas() {
		return em().createQuery("FROM Sala").getResultList();
	}

	@Override
	public Sala buscarPorId(long id) {
		return em().find(Sala.class, id);
	}

	@Override
	public void incluir(Sala sala) {
		EntityManager em = em();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(sala);
		tx.commit();
	}

	private EntityManager em() {
		return emf.createEntityManager();
	}

}
