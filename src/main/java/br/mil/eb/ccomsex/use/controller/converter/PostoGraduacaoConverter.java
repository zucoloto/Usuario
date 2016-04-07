package br.mil.eb.ccomsex.use.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.mil.eb.ccomsex.use.model.entity.PostoGraduacao;
import br.mil.eb.ccomsex.use.model.repository.PostoGraduacaoRepository;

@FacesConverter(forClass = PostoGraduacao.class)
public class PostoGraduacaoConverter implements Converter {

	@Inject
	private PostoGraduacaoRepository postoGraduacaoRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		PostoGraduacao retorno = null;
		if (value != null && !value.equals("")) {
			retorno = postoGraduacaoRepository.buscarPorId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			PostoGraduacao retorno = (PostoGraduacao) value;
			return retorno.getId() == null ? null : retorno.getId().toString();
		}
		return null;
	}

}
