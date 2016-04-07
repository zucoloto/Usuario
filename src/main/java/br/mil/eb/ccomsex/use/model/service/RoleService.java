package br.mil.eb.ccomsex.use.model.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.mil.eb.ccomsex.use.model.entity.Role;
import br.mil.eb.ccomsex.use.model.repository.RoleRepository;
import br.mil.eb.ccomsex.use.model.service.exception.NegocioException;
import br.mil.eb.ccomsex.use.util.jpa.Transactional;

public class RoleService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private RoleRepository roleRepository;

	@Transactional
	public void salvar(Role role) {
		roleRepository.salvar(role);
	}

	@Transactional
	public void excluir(Role role) {
		role = buscarPorId(role.getId());
		try {
			roleRepository.excluir(role);
		} catch (PersistenceException e) {
			throw new NegocioException("exclusao_negada");
		}
	}

	public Role buscarPorId(Long id) {
		return roleRepository.buscarPorId(id);
	}

	public List<Role> listarTodos() {
		return roleRepository.listarTodos();
	}

}
