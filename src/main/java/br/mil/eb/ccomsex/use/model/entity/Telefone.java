package br.mil.eb.ccomsex.use.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "use_telefone")
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "numero_telefone")
	private String numeroTelefone;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_telefone")
	private TipoTelefone tipoTelefone;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

}
