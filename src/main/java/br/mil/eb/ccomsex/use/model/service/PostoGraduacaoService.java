package br.mil.eb.ccomsex.use.model.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.mil.eb.ccomsex.use.model.dao.PostoGraduacaoDAO;
import br.mil.eb.ccomsex.use.model.entity.PostoGraduacao;
import br.mil.eb.ccomsex.use.model.service.exception.NegocioException;
import br.mil.eb.ccomsex.use.util.jpa.Transactional;

public class PostoGraduacaoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PostoGraduacaoDAO postoGraduacaoDAO;

	@Transactional
	public void salvar(PostoGraduacao postoGraduacao) {
		postoGraduacaoDAO.salvar(postoGraduacao);
	}

	@Transactional
	public void excluir(PostoGraduacao postoGraduacao) {
		postoGraduacao = buscarPorId(postoGraduacao.getId());
		try {
			postoGraduacaoDAO.excluir(postoGraduacao);
		} catch (PersistenceException e) {
			throw new NegocioException("exclusao_negada");
		}
	}

	public PostoGraduacao buscarPorId(Long id) {
		return postoGraduacaoDAO.pesquisarPorId(id);
	}

	public List<PostoGraduacao> listarTodos() {
		return postoGraduacaoDAO.listarTodos();
	}

}
