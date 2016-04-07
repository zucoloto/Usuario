/*package br.mil.eb.ccomsex.use.controller.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.use.model.entity.Usuario;
import br.mil.eb.ccomsex.use.model.service.UsuarioService;

@Named
@ViewScoped
public class PesquisarEntityBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;

	private Usuario usuario;

	private List<Usuario> usuarios;

	public void inicializar() {
		pesquisar();
	}

	public void pesquisar() {
		this.usuarios = usuarioService.listarTodos();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

}
*/