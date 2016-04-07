package br.mil.eb.ccomsex.use.controller.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.use.model.entity.Fracao;
import br.mil.eb.ccomsex.use.model.service.FracaoService;

@Named
@ViewScoped
public class PesquisarFracaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FracaoService fracaoService;

	private Fracao fracao;

	private List<Fracao> fracoes;

	public void inicializar() {
		pesquisar();
	}

	public void pesquisar() {
		this.fracoes = fracaoService.listarTodos();
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

}
