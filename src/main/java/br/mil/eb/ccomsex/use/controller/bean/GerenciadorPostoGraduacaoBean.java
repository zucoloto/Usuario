package br.mil.eb.ccomsex.use.controller.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.use.model.entity.PostoGraduacao;
import br.mil.eb.ccomsex.use.model.service.PostoGraduacaoService;
import br.mil.eb.ccomsex.use.model.service.exception.NegocioException;
import br.mil.eb.ccomsex.use.util.jsf.FacesUtil;

@Named
@ViewScoped
public class GerenciadorPostoGraduacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PostoGraduacaoService postoGraduacaoService;

	private PostoGraduacao postoGraduacao;

	public void inicializar() {
		if (this.postoGraduacao == null) {
			limpar();
		}
	}

	public void limpar() {
		this.postoGraduacao = new PostoGraduacao();
	}

	public boolean isEditando() {
		return this.postoGraduacao.getId() != null;
	}

	public void salvar() {
		try {
			postoGraduacaoService.salvar(this.postoGraduacao);
			limpar();
			FacesUtil.addInfoMessage(FacesUtil.getMensagemI18n("registro_salvo"));
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(FacesUtil.getMensagemI18n(e.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.addFatalMessage(FacesUtil.getMensagemI18n("contato_administrador"));
		}
	}

	public PostoGraduacao getPostoGraduacao() {
		return postoGraduacao;
	}

	public void setPostoGraduacao(PostoGraduacao postoGraduacao) {
		this.postoGraduacao = postoGraduacao;
	}

}