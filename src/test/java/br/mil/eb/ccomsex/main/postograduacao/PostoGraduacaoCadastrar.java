package br.mil.eb.ccomsex.main.postograduacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.mil.eb.ccomsex.use.model.entity.PostoGraduacao;
import br.mil.eb.ccomsex.util.jpa.JPAUtil;

public class PostoGraduacaoCadastrar {

	private EntityManager entityManager;
	private EntityTransaction trx;

	@Before
	public void setUp() {
		entityManager = JPAUtil.createEntityManager();
		trx = entityManager.getTransaction();
		trx.begin();
	}

	@After
	public void tearDown() {
		trx.commit();
		entityManager.close();
	}

	@Test
	public void Executar() {
		PostoGraduacao pg = new PostoGraduacao();
		pg.setCodigo("1");
		pg.setDescricao("Subtenente");
		pg.setSigla("S Ten");

		entityManager.persist(pg);
	}
}
