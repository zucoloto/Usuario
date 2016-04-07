package br.mil.eb.ccomsex.use.model.repository;

import java.util.List;

import br.mil.eb.ccomsex.use.model.entity.Role;

public interface RoleRepository {

	public void salvar(Role role);

	public void excluir(Role role);

	public Role buscarPorId(Long id);

	public List<Role> listarTodos();
	
}
