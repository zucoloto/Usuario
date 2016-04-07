package br.mil.eb.ccomsex.use.controller.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.use.model.entity.PostoGraduacao;
import br.mil.eb.ccomsex.use.model.entity.StatusUsuario;
import br.mil.eb.ccomsex.use.model.entity.Usuario;
import br.mil.eb.ccomsex.use.model.service.PostoGraduacaoService;
import br.mil.eb.ccomsex.use.model.service.UsuarioService;
import br.mil.eb.ccomsex.use.model.service.exception.NegocioException;
import br.mil.eb.ccomsex.use.util.jsf.FacesUtil;

@Named
@ViewScoped
public class GerenciadorUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;

	private Usuario usuario;

	@Inject
	private PostoGraduacaoService postoGraduacaoService;

	private List<PostoGraduacao> postoGraduacoes;

	public void inicializar() {
		if (this.usuario == null) {
			limpar();
		}
		carregarPostoGraduacao();
	}

	public void limpar() {
		this.usuario = new Usuario();
	}

	public boolean isEditando() {
		return this.usuario.getId() != null;
	}

	public void salvar() {
		try {
			usuarioService.salvar(this.usuario);
			limpar();
			FacesUtil.addInfoMessage(FacesUtil.getMensagemI18n("registro_salvo"));
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(FacesUtil.getMensagemI18n(e.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.addFatalMessage(FacesUtil.getMensagemI18n("contato_administrador"));
		}
	}

	public StatusUsuario[] getStatusUsuario() {
		return StatusUsuario.values();
	}

	public void carregarPostoGraduacao() {
		this.postoGraduacoes = postoGraduacaoService.listarTodos();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<PostoGraduacao> getPostoGraduacoes() {
		return postoGraduacoes;
	}

}
