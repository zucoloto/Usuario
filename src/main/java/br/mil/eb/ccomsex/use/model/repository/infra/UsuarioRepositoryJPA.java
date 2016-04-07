package br.mil.eb.ccomsex.use.model.repository.infra;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.mil.eb.ccomsex.use.model.entity.Usuario;
import br.mil.eb.ccomsex.use.model.repository.UsuarioRepository;

public class UsuarioRepositoryJPA implements UsuarioRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	@Override
	public void salvar(Usuario usuario) {
		usuario = entityManager.merge(usuario);

	}

	@Override
	public Usuario buscarPorId(Long id) {
		return entityManager.find(Usuario.class, id);
	}

	@Override
	public List<Usuario> listarTodos() {
		return entityManager.createQuery("from Usuario order by nomeUsuario", Usuario.class).getResultList();
	}

	@Override
	public Usuario buscarPorIdentidade(String identidade) {
		Usuario usuario = null;
		usuario = entityManager.createQuery("from Usuario where identidade = :pIdentidade", Usuario.class)
				.setParameter("pIdentidade", identidade).getSingleResult();
		return usuario;
	}

}
