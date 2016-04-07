package br.mil.eb.ccomsex.use.model.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.mil.eb.ccomsex.use.model.entity.Usuario;
import br.mil.eb.ccomsex.use.model.repository.UsuarioRepository;
import br.mil.eb.ccomsex.use.util.jpa.Transactional;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioRepository usuarioRepository;

	@Transactional
	public void salvar(Usuario usuario) {
		usuarioRepository.salvar(usuario);
	}

	public Usuario buscarPorId(Long id) {
		return usuarioRepository.buscarPorId(id);
	}

	public List<Usuario> listarTodos() {
		return usuarioRepository.listarTodos();
	}

	public Usuario buscarPorIdentidade(String identidade) {
		return usuarioRepository.buscarPorIdentidade(identidade);
	}

}
