package br.mil.eb.ccomsex.use.model.dao.infra;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.mil.eb.ccomsex.use.model.dao.GenericDAO;

public class GenericDAOInfra<T, ID extends Serializable> implements GenericDAO<T, ID> {

	@Inject
	private EntityManager entityManager;

	private Class<T> classeEntidade;

	@SuppressWarnings("unchecked")
	public GenericDAOInfra() {
		this.classeEntidade = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public void salvar(T endidade) {
		entityManager.merge(endidade);
	}

	@Override
	public void excluir(T endidade) {
		entityManager.remove(endidade);
		entityManager.flush();
	}

	@Override
	public T pesquisarPorId(ID id) {
		return entityManager.getReference(classeEntidade, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listarTodos() {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(classeEntidade);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> pesquisar(T entidade, String... propriedades) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(classeEntidade);

		if (propriedades != null) {
			for (String propriedade : propriedades) {
				try {
					Object valor = PropertyUtils.getProperty(entidade, propriedade);
					if (valor != null) {
						if (valor instanceof String) {
							criteria.add(Restrictions.ilike(propriedade, (String) valor, MatchMode.ANYWHERE));
						} else {
							criteria.add(Restrictions.eq(propriedade, valor));
						}
					}
				} catch (Exception e) {
					throw new RuntimeException("Propriedade não encontrada", e);
				}
			}
		}

		return criteria.list();
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	protected Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	

}
