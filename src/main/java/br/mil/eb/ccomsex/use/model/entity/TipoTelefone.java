package br.mil.eb.ccomsex.use.model.entity;

public enum TipoTelefone {
	 
	CELULAR_FUNCIONAL("Celular Funcional"),
	CELULAR_PESSOAL("Celular Pessoal"),
	RESIDENCIAL("Residencial"),
	TRABALHO("Trabalho");

	private String descricao;

	TipoTelefone(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
