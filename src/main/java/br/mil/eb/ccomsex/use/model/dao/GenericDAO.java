package br.mil.eb.ccomsex.use.model.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

	public void salvar(T endidade);
	
	public void excluir(T endidade);
	
	public T pesquisarPorId(ID id);
	
	public List<T> listarTodos();
	
	public List<T> pesquisar(T entidade, String... propriedades);
}
