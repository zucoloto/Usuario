package br.mil.eb.ccomsex.use.model.repository.infra;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.mil.eb.ccomsex.use.model.entity.Role;
import br.mil.eb.ccomsex.use.model.repository.RoleRepository;

public class RoleRepositoryJPA implements RoleRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	@Override
	public void salvar(Role role) {
		entityManager.merge(role);
	}

	@Override
	public void excluir(Role role) {
		entityManager.remove(role);
		entityManager.flush();
	}

	@Override
	public Role buscarPorId(Long id) {
		return entityManager.find(Role.class, id);
	}

	@Override
	public List<Role> listarTodos() {
		return entityManager.createQuery("from Role", Role.class).getResultList();
	}

}
