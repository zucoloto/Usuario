package br.mil.eb.ccomsex.use.controller.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.use.model.entity.Fracao;
import br.mil.eb.ccomsex.use.model.entity.PostoGraduacao;
import br.mil.eb.ccomsex.use.model.entity.Role;
import br.mil.eb.ccomsex.use.model.entity.StatusUsuario;
import br.mil.eb.ccomsex.use.model.entity.Usuario;
import br.mil.eb.ccomsex.use.model.service.FracaoService;
import br.mil.eb.ccomsex.use.model.service.PostoGraduacaoService;
import br.mil.eb.ccomsex.use.model.service.RoleService;
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

	@Inject
	private FracaoService fracaoService;

	private Fracao fracao;

	private List<Fracao> fracoes;

	@Inject
	private RoleService roleService;

	private List<Role> roles;

	public void inicializar() {
		if (this.usuario == null) {
			limpar();
		}
		carregarPostoGraduacao();
		carregarFracao();
		carregarRole();
	}

	public void limpar() {
		this.usuario = new Usuario();
		this.usuario.setFracoes(new ArrayList<Fracao>());
		this.usuario.setRoles(new ArrayList<Role>());
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

	public void adicionarFracao() {
		this.usuario.getFracoes().add(fracao);
		//fracoes.remove(fracao);
	}

	public void excluirFracao() {
		usuario.getFracoes().remove(fracao);
		//fracoes.add(fracao);
	}

	public StatusUsuario[] getStatusUsuario() {
		return StatusUsuario.values();
	}

	public void carregarPostoGraduacao() {
		this.postoGraduacoes = postoGraduacaoService.listarTodos();
	}

	public void carregarFracao() {
		this.fracoes = fracaoService.listarTodos();
	}

	public void carregarRole() {
		this.roles = roleService.listarTodos();
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

	public Fracao getFracao() {
		return fracao;
	}

	public void setFracao(Fracao fracao) {
		this.fracao = fracao;
	}

	public List<Fracao> getFracoes() {
		return fracoes;
	}

	public List<Role> getRoles() {
		return roles;
	}

}
