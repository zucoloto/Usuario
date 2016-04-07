package br.mil.eb.ccomsex.use.model.repository;

import java.util.List;

import br.mil.eb.ccomsex.use.model.entity.Usuario;

public interface UsuarioRepository {

	public void salvar(Usuario usuario);

	public Usuario buscarPorId(Long id);

	public List<Usuario> listarTodos();

	public Usuario buscarPorIdentidade(String identidade);

}
