package br.mil.eb.ccomsex.use.model.repository;

import java.util.List;

import br.mil.eb.ccomsex.use.model.entity.PostoGraduacao;

public interface PostoGraduacaoRepository {

	public void salvar(PostoGraduacao postoGraduacao);

	public void excluir(PostoGraduacao postoGraduacao);

	public PostoGraduacao buscarPorId(Long id);

	public List<PostoGraduacao> listarTodos();

}
