package br.mil.eb.ccomsex.use.controller.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.use.model.entity.Role;
import br.mil.eb.ccomsex.use.model.service.RoleService;
import br.mil.eb.ccomsex.use.model.service.exception.NegocioException;
import br.mil.eb.ccomsex.use.util.jsf.FacesUtil;

@Named
@ViewScoped
public class GerenciadorRoleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private RoleService roleService;

	private Role role;

	public void inicializar() {
		if (this.role == null) {
			limpar();
		}
	}

	public void limpar() {
		this.role = new Role();
	}

	public boolean isEditando() {
		return this.role.getId() != null;
	}

	public void salvar() {
		try {
			roleService.salvar(this.role);
			limpar();
			FacesUtil.addInfoMessage(FacesUtil.getMensagemI18n("registro_salvo"));
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(FacesUtil.getMensagemI18n(e.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.addFatalMessage(FacesUtil.getMensagemI18n("contato_administrador"));
		}
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
