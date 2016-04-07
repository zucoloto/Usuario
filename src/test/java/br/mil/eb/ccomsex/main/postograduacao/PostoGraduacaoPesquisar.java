package br.mil.eb.ccomsex.main.postograduacao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.mil.eb.ccomsex.use.model.entity.PostoGraduacao;
import br.mil.eb.ccomsex.util.jpa.JPAUtil;

public class PostoGraduacaoPesquisar {

	private EntityManager entityManager;

	@Before
	public void setUp() {
		entityManager = JPAUtil.createEntityManager();
	}

	@After
	public void tearDown() {
		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void listarTodos() {
		Session session = this.entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(PostoGraduacao.class);

		List<PostoGraduacao> pgs = criteria.list();

		for (PostoGraduacao pg : pgs) {
			System.out.println(pg.getId() + " - " + pg.getCodigo() + " - " + pg.getSigla());
		}
	}
}
