package br.mil.eb.ccomsex.use.model.repository.infra;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.mil.eb.ccomsex.use.model.entity.PostoGraduacao;
import br.mil.eb.ccomsex.use.model.repository.PostoGraduacaoRepository;

public class PostoGraduacaoRepositoryJPA implements PostoGraduacaoRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	@Override
	public void salvar(PostoGraduacao postoGraduacao) {
		entityManager.merge(postoGraduacao);
	}

	@Override
	public void excluir(PostoGraduacao postoGraduacao) {
		entityManager.remove(postoGraduacao);
		entityManager.flush();
	}

	@Override
	public PostoGraduacao buscarPorId(Long id) {
		return entityManager.find(PostoGraduacao.class, id);
	}

	@Override
	public List<PostoGraduacao> listarTodos() {
		return entityManager.createQuery("select p from PostoGraduacao p order by codigo", PostoGraduacao.class)
				.getResultList();
	}

}
