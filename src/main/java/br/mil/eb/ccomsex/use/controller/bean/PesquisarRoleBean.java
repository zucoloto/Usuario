package br.mil.eb.ccomsex.use.controller.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.use.model.entity.Role;
import br.mil.eb.ccomsex.use.model.service.RoleService;

@Named
@ViewScoped
public class PesquisarRoleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private RoleService roleService;

	private Role role;

	private List<Role> roles;

	public void inicializar() {
		pesquisar();
	}

	public void pesquisar() {
		this.roles = roleService.listarTodos();
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoles() {
		return roles;
	}

}
