package br.mil.eb.ccomsex.main.usuarioendereco;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.mil.eb.ccomsex.use.model.entity.Endereco;
import br.mil.eb.ccomsex.use.model.entity.PostoGraduacao;
import br.mil.eb.ccomsex.use.model.entity.StatusUsuario;
import br.mil.eb.ccomsex.use.model.entity.Usuario;
import br.mil.eb.ccomsex.util.jpa.JPAUtil;

public class Cadastrar {

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
		Usuario u = new Usuario();
		Endereco e = new Endereco();
		
		u.setIdentidade("1");
		u.setNomeUsuario("Teste1");
		u.setPostoGraduacao(pesquisarPostoGraduacao());
		u.setEmail("teste1@gmail.com");
		u.setStatusUsuario(StatusUsuario.ATIVO);
		u.setSenha("123");
		u.setEndereco(e);

		// entityManager.persist(u);
		
		e.setLogradouro("Endereço1");
		e.setUsuario(u);

		u.setEndereco(e);

		entityManager.persist(u);
	}

	private PostoGraduacao pesquisarPostoGraduacao() {
		return entityManager.getReference(PostoGraduacao.class, 1L);
	}
}
