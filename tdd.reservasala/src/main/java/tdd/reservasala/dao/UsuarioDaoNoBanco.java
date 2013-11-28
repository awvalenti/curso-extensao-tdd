package tdd.reservasala.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import br.com.caelum.vraptor.ioc.Component;
import tdd.reservasala.domain.Usuario;

@Component
public class UsuarioDaoNoBanco implements UsuarioDao {

	private final EntityManagerFactory emf;

	public UsuarioDaoNoBanco(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void incluir(Usuario usuario) {
		EntityManager em = em();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(usuario);
		tx.commit();
	}

	private EntityManager em() {
		return emf.createEntityManager();
	}

}
