package br.mil.eb.ccomsex.use.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.mil.eb.ccomsex.use.model.entity.Fracao;
import br.mil.eb.ccomsex.use.model.repository.FracaoRepository;

//@FacesConverter(forClass = Fracao.class)
@FacesConverter("fracaoConverter")
public class FracaoConverter implements Converter {

	@Inject
	private FracaoRepository fracaoRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Fracao retorno = null;
		if (value != null && !value.equals("")) {
			retorno = fracaoRepository.buscarPorId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Fracao retorno = (Fracao) value;
			return retorno.getId() == null ? null : retorno.getId().toString();
		}
		return null;
	}

}
