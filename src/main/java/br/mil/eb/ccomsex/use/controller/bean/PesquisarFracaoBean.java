package br.mil.eb.ccomsex.use.controller.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

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

	private TreeNode raiz;

	public void inicializar() {
		List<Fracao> fracaoRaizes = fracaoService.raizes();
		this.raiz = new DefaultTreeNode("Raiz", null);
		adicionarNos(fracaoRaizes, this.raiz);
	}

	private void adicionarNos(List<Fracao> fracoesNos, TreeNode pai) {
		for (Fracao fracao : fracoesNos) {
			TreeNode no = new DefaultTreeNode(fracao, pai);

			adicionarNos(fracao.getSubFracoes(), no);
		}
	}

	public TreeNode getRaiz() {
		return raiz;
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
