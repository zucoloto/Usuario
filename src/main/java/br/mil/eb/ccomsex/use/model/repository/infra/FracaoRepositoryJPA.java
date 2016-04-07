package br.mil.eb.ccomsex.use.model.repository.infra;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.mil.eb.ccomsex.use.model.entity.Fracao;
import br.mil.eb.ccomsex.use.model.repository.FracaoRepository;

public class FracaoRepositoryJPA implements FracaoRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	@Override
	public void salvar(Fracao fracao) {
		entityManager.merge(fracao);
	}

	@Override
	public void excluir(Fracao fracao) {
		entityManager.remove(fracao);
		entityManager.flush();
	}

	@Override
	public Fracao buscarPorId(Long id) {
		return entityManager.find(Fracao.class, id);
	}

	@Override
	public List<Fracao> listarTodos() {
		return entityManager.createQuery("select f from Fracao f order by ordemQC", Fracao.class).getResultList();
	}

	@Override
	public List<Fracao> raizes() {
		return entityManager.createQuery("from Fracao where fracaoPaiId is null order by ordemQC", Fracao.class)
				.getResultList();
	}

}
