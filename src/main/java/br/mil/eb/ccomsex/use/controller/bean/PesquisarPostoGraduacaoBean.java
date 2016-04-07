package br.mil.eb.ccomsex.use.controller.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.use.model.entity.PostoGraduacao;
import br.mil.eb.ccomsex.use.model.service.PostoGraduacaoService;
import br.mil.eb.ccomsex.use.model.service.exception.NegocioException;
import br.mil.eb.ccomsex.use.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisarPostoGraduacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PostoGraduacaoService postoGraduacaoService;

	private PostoGraduacao postoGraduacao;

	private List<PostoGraduacao> postoGraduacoes;
	
	public void inicializar() {
		pesquisar();
	}

	public void pesquisar() {
		this.postoGraduacoes = postoGraduacaoService.listarTodos();
	}

	public void excluir() {
		try {
			postoGraduacaoService.excluir(postoGraduacao);
			// this.postoGraduacoes.remove(postoGraduacao);
			FacesUtil.addInfoMessage(FacesUtil.getMensagemI18n("registro_excluido"));
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(FacesUtil.getMensagemI18n(e.getMessage()));
		}
	}

	public PostoGraduacao getPostoGraduacao() {
		return postoGraduacao;
	}

	public void setPostoGraduacao(PostoGraduacao postoGraduacao) {
		this.postoGraduacao = postoGraduacao;
	}

	public List<PostoGraduacao> getPostoGraduacoes() {
		return postoGraduacoes;
	}

}
